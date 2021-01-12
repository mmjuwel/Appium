var loginpage = require('../pageObjects/Login_page.js')
describe('Login into system', () => {

    it('should load Base URL of the System', () => {
        browser.waitForAngularEnabled(true);
        loginpage.getUrl('http://www.way2automation.com/angularjs-protractor/registeration/#/login');
        browser.waitForAngularEnabled(true);
    });

    it('should insert userID', () => {
        loginpage.setusername('angular')
    });

    it('should insert Password', () => {
        loginpage.setPassword('password');

    });

    it('should insert Second user name', () => {
        loginpage.setUserName('angular');
    });

    it('should Click on Login Button', () => {
        loginpage.clickLoginBtn();
        browser.waitForAngular();
    });

    describe('Verify Login ', () => {
        it('should verify the Log in Success or Not', () => {
            let errorMessage = loginpage.getFailedMessage();
            expect(errorMessage).not.toContain('incorrect');
        });

        it('should verufy Login success', () => {

            expect(loginpage.gethomePage()).toContain('Home');

        });


    });

});