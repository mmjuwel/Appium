describe('First protractor Code run', function () {
    it('sum of 2 numbers', function () {

        browser.get('http://juliemr.github.io/protractor-demo/');
        element(by.model('first')).sendKeys('5');
        element(by.model('second')).sendKeys('8');

        element(by.css('[ng-click="doAddition()"]')).click();

        element(by.css('[]'))
        browser.sleep(3000);

    });
});