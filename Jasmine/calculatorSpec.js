describe("Calculator Desc", function () {
    var cal;

    beforeEach(function () {
        cal = require('./calculator.js');

            between = function (a,b) {
                this.actual >=a && b<= this.actual;
            }
        
    });



    it('should be able to add  2 num ', function () {
        expect(cal.add(1, 1)).toBe(2);
        
    });

    it('should be able to divide 2 val', () => {
        expect(cal.divide(1, 3)).between(0.33,0.34);
    });

});