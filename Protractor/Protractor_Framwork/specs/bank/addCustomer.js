let addCustomer = require('../../pageObjects/bank/addCustomer_page.js');
let homePage = require('../../pageObjects/bank/home_page.js');
describe('Add New  Customer: ', () => {

    describe(' Bank manager Login: ', () => {

        beforeAll(() => {
            homePage.getBaseUrl('http://www.way2automation.com/angularjs-protractor/banking/#/login');
            browser.waitForAngular();
        });
        it('Should verify Home Page ', () => {
            expect(homePage.getHomeButton()).toContain('Home');
        });

        it('Should Successfully login', () => {
            homePage.clickBaankManagerLogin();
            browser.waitForAngular();
        });
    });

    it('Should Click on Add Customer Button & Very user is in "Create New Account" page', () => {
        addCustomer.clickAddCustomerbtn();
        browser.waitForAngular();
        let btnNmae = addCustomer.getAddCustomerButtonName();
        expect(btnNmae).toContain('Add Customer');
    });

    it('Should Insert First Name of Customer', () => {
        addCustomer.setfirstName("First Name");
    });

    it('Should Insert Last Name of Customer', () => {
        addCustomer.setlastName("Last Name");
    });

    it('Should Insert Post Code', () => {
        addCustomer.setpostCode("1208");
    });

    it('Should Click on Add Customer button to Save', () => {
        addCustomer.clickAddCustomer();
    });

    it('Should verify the Save of New Customer', () => {
        let confAlert = browser.switchTo().alert();
        let message = confAlert.getText();
        console.log('Your Alert Message is ' + message + " End Message *****");
        expect(message).toContain('Customer added successfully');

    });
});