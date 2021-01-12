$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("E:/SE Project/Project/Cucumber/src/main/java/features/LogIn.feature");
formatter.feature({
  "line": 1,
  "name": "Login into ERP",
  "description": "",
  "id": "login-into-erp",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 44,
  "name": "Calculation",
  "description": "",
  "id": "login-into-erp;calculation",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 43,
      "name": "@Test"
    }
  ]
});
formatter.step({
  "line": 45,
  "name": "two numberes \u003ca\u003e and \u003cb\u003e",
  "keyword": "Given "
});
formatter.examples({
  "line": 46,
  "name": "",
  "description": "",
  "id": "login-into-erp;calculation;",
  "rows": [
    {
      "cells": [
        "a",
        "b"
      ],
      "line": 47,
      "id": "login-into-erp;calculation;;1"
    },
    {
      "cells": [
        "10",
        "15"
      ],
      "line": 48,
      "id": "login-into-erp;calculation;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 48,
  "name": "Calculation",
  "description": "",
  "id": "login-into-erp;calculation;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 43,
      "name": "@Test"
    }
  ]
});
formatter.step({
  "line": 45,
  "name": "two numberes 10 and 15",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "10",
      "offset": 13
    },
    {
      "val": "15",
      "offset": 20
    }
  ],
  "location": "LogIn_StepsDef.two_numberes_a_and_b(int,int)"
});
formatter.result({
  "duration": 3050164631,
  "status": "passed"
});
});