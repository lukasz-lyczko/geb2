package Pages.modules

import geb.Module

class FooterModule extends Module {
    static content = {
        footer {$('footer>div:last-child')}
        termsLink {footer.$('a[data-footer-tac]')}
        supportLink {footer.$('a:last-child')}
    }
}
