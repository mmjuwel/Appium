exports.config = {
    directConnect: true,

    capabilities: {
        'browserName': 'chrome'
    },

    framework: 'jasmine',
   // specs: ['../specs/bank/addCustomer.js'],
    
    specs: ['../utilities/excelutil.js'],
    // Options to be passed to Jasmine.
    jasmineNodeOpts: {
      defaultTimeoutInterval: 30000
    }
};