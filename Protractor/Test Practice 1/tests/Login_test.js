var login = require('../page_objects/Login_page');


describe('ACC ERP  Login',  function () {

    it('should Load Landing Page', async function () {

        await login.baseUrl("http://erp.nextaccbd.com/");
        browser.sleep(3000);
        //browser.waitForAngularEnabled(true);
       // browser.waitForAngular();
        let loading = ExpectedConditions.invisibilityOf(element(by.id("overlay-background")));
        browser.wait(loading, 30000);

    });

    it('Should insert user ID', async function () {
        await login.insertUserName('anis');
    });


    it('Should insert Password', async function () {

        await login.insertPassword('ARahman777');
    });

    it('Sould click on Login Button', async function () {

        browser.waitForAngularEnabled(true);
        await  login.clickOnLogin();
    });

    it('should Verify the Dashboard', async function () {

        console.log(await login.loggedUser());
    });

});