import {createApp} from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import vuetify from './plugins/vuetify'
import {loadFonts} from './plugins/webfontloader'
/* import the fontawesome core */
import {library} from '@fortawesome/fontawesome-svg-core'

/* import font awesome icon component */

/* import specific icons */
import {faUserSecret} from '@fortawesome/free-solid-svg-icons'

/* add icons to the library */
library.add(faUserSecret)

loadFonts()

createApp(App)
    .use(router)
    .use(store)
    .use(vuetify)
    .mount('#app')
