let logInPage = function () {

    let username = element(by.model('Auth.user.name'));
    let password = element(by.model('Auth.user.password'));
    let userName = element(by.model('model[options.key]'));
    let loginBtn = element(by.tagName('button'));
    let faildMessage = element(by.className('alert-danger'));
    let homePage = element(by.tagName('h1'));


    this.getUrl= function (url) {
        browser.get(url);
    }
    this.setusername = function (Username) {
        username.clear().sendKeys(Username);
    };

    this.setPassword = function (pass) {
        password.clear().sendKeys(pass);
    };

    this.setUserName = function (UserName) {
        userName.clear().sendKeys(UserName);
    };

    this.clickLoginBtn = function () {
        loginBtn.click();
    };

    this.getFailedMessage = function () {
        return faildMessage.getText();
    };
    this.gethomePage = function () {
        return homePage.getText();
    };

};

module.exports =new logInPage();