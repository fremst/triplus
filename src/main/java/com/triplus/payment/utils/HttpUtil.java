package com.triplus.payment.utils;

import java.util.Iterator;
import java.util.Map;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HostConfiguration;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HttpUtil {
    private static Log log = LogFactory.getLog(com.inicis.std.util.HttpUtil.class);
    private static int CONNECTION_TIMEOUT = 5000;
    private static int RECEIVE_TIMEOUT = 25000;
    private HttpClient client;
    private PostMethod postMethod;
    private HostConfiguration hostConf;

    public HttpUtil() {
    }

    public String processHTTP(Map request, String actionURL) throws Exception {
        int statusCode = 0;
        String result = null;
        log.info("REQUEST URL  : " + actionURL);
        log.info("PARAM: " + request.toString());

        String var24;
        try {
            this.hostConf = new HostConfiguration();
            this.client = new HttpClient();
            this.client.getHttpConnectionManager().getParams().setConnectionTimeout(CONNECTION_TIMEOUT);
            this.client.getHttpConnectionManager().getParams().setSoTimeout(RECEIVE_TIMEOUT);
            this.postMethod = new PostMethod(actionURL);
            this.postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; text/html; charset=euc-kr");
            this.postMethod.setRequestHeader("Cache-Control", "no-cache");
            this.hostConf.setHost(this.postMethod.getURI().getHost(), this.postMethod.getURI().getPort());
            NameValuePair[] params = this.makeParam(request);
            this.postMethod.setRequestBody(params);

            try {
                statusCode = this.client.executeMethod(this.postMethod);
            } catch (Exception var21) {
                log.error("서버응답 에러 / " + statusCode, var21);
                System.out.println("서버응답 에러 / " + statusCode);
                var21.printStackTrace();
                throw var21;
            }

            Header[] var6 = this.postMethod.getResponseHeaders();
            int var7 = var6.length;

            for (int var8 = 0; var8 < var7; ++var8) {
                Header header = var6[var8];
                log.debug(header.getName() + "=" + header.getValue());
            }

            if (statusCode != 200) {
                System.out.println("서버응답 에러 / " + statusCode);
                throw new HttpException("서버응답 에러 / " + statusCode);
            }

            result = this.postMethod.getResponseBodyAsString();
            log.info("RESPONSE DATA: " + result.trim());
            var24 = result.trim();
        } catch (Exception var22) {
            var22.printStackTrace();
            log.error("서버응답 에러 / " + statusCode, var22);
            log.debug("HTTP 통신에러 발생 / \nREQUEST URL  : " + actionURL + "\nREQUEST PARAM: " + request.toString() + "\nRESPONSE DATA: " + result);
            throw var22;
        } finally {
            try {
                if (this.postMethod != null) {
                    this.postMethod.releaseConnection();
                }
            } catch (Exception var20) {
                this.postMethod = null;
            }

            try {
                if (this.client != null) {
                    this.client.getHttpConnectionManager().getConnection(this.hostConf).close();
                }
            } catch (Exception var19) {
            }

        }

        return var24;
    }

    public NameValuePair[] makeParam(Map request) throws Exception {
        int hashSize = request.size();
        Iterator keyset = request.keySet().iterator();
        NameValuePair[] params = new NameValuePair[hashSize];
        String key = "";

        for (int i = 0; i < hashSize; ++i) {
            key = (String) keyset.next();
            params[i] = new NameValuePair(key, new String(((String) request.get(key)).getBytes(), "KSC5601"));
        }

        return params;
    }
}