let addCustomer = function () {
    let addCustomerbtn = element(by.css('[ng-click="addCust()"]'));
    let firstName = element(by.model('fName'));
    let lastName = element(by.model('lName'));
    let postCode = element(by.model('postCd'));
    let addCustomer = element(by.css('.btn-default'));
    


    this.clickAddCustomerbtn = function () {
        addCustomerbtn.click();
    };

    this.setfirstName = function (fname) {
        firstName.clear().sendKeys(fname);
    };
    this.setlastName = function (lname) {
        lastName.clear().sendKeys(lname);
    };

    this.setpostCode = function (PostCode) {
        postCode.clear().sendKeys(PostCode);
    };

    this.clickAddCustomer = function () {
        addCustomer.click();
    };
    this.getAddCustomerButtonName = function() {
        return addCustomer.getText();
    };

};

module.exports = new addCustomer();