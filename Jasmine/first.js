describe("A suite", function () {
  beforeAll(function (params) {
    console.log('this is Before ALL')
  })


  beforeEach(function () {
    console.log('This is before Each ')
  })



  it("AA contains spec with an expectation", function () {
    console; console.log("Hello world ...");
  });

  it('Add two numbers', function () {
    let result = 2 + 2;
    console.log('Result: ' + result);
    expect(result).toBe(4);
  });

  it('Add two numbers', function () {
    let result = 3 + 3;
    console.log('Result: ' + result);
    expect(result).not.toBe(5)
  });


  afterEach(function () {
    console.log("this is after each")
  })



  afterAll(function (params) {
    console.log('This is after All')
  })



});