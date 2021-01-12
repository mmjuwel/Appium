var calculator = function () {
    
};

calculator.prototype.add = function (a, b) {
    return a+b;
};

calculator.prototype.divide = function (a , b) {
    return a/b;
};


module.exports= new calculator();