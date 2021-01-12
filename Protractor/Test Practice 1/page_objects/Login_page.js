let LoginPage = function () {

    let userName = element(by.id('userName'));
    let password = element(by.id('password'));
    let loginButton = element(by.id('btnLogIn'));
    let logginuser = element(by.css('.pull-right.nav .dropdown-toggle > span:nth-of-type(2)'));

    this.baseUrl = async function (url) {

        browser.get(url);
        browser.getTitle().then(function (title) {
            console.log("Web page title is : " + title)
        })
    }

    this.insertUserName = async function (user_name) {

        userName.sendKeys(user_name);
    };

    this.insertPassword = async function (pass) {

        password.sendKeys(pass);
    };

    this.clickOnLogin = async function () {

        loginButton.click();
    };

    this.loggedUser = async  function () {
        let user = logginuser.getText();
        return user;
    }
};

module.exports = new LoginPage();