var homePage = function () {

    let homebtn = element(by.deepCss('[ng-click="home()"]'));
    let customerlogin = element(by.css('[ng-click="customer()"]'));
    let bankManagerLogin = element(by.css('[ng-click="manager()"]'));

    this.getBaseUrl = function (baseUrl) {
        browser.get(baseUrl);
    }

    this.getHomeButton = function () {
        return homebtn.getText();
    }
    this.clickCustomerLogin = function () {
        customerlogin.click();
    };

    this.clickBaankManagerLogin = function () {
        bankManagerLogin.click();
    };
};

module.exports = new homePage();