var homePage = require('../../pageObjects/bank/home_page.js')
describe('Bank Application Home Page', () => {
    it('Should load Home page of bank Application', () => {
        homePage.getBaseUrl('http://www.way2automation.com/angularjs-protractor/banking/#/login');
        browser.waitForAngular();
    });

    it('should verify the Home Page Loaded', () => {
       let homebtl= homePage.getHomeButton();
        expect(homebtl).toContain('Home');
    });
});