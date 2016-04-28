$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("AssessChangeRequest.feature");
formatter.feature({
  "line": 1,
  "name": "Assess change request",
  "description": "In order to either approve or reject change requests\nAs a project manager\nI want to revise change requests",
  "id": "assess-change-request",
  "keyword": "Feature"
});
formatter.before({
  "duration": 25069551,
  "status": "passed"
});
formatter.before({
  "duration": 7291174,
  "status": "passed"
});
formatter.before({
  "duration": 9242361,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "accept a change request",
  "description": "",
  "id": "assess-change-request;accept-a-change-request",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 6,
      "name": "@domain"
    }
  ]
});
formatter.step({
  "line": 8,
  "name": "the pending change request \"Fault\" in a list of pending requests",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "I accept it with priority \"high\" for developer \"A\" with deadline \"17-11-2015\"",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "the change request \"Fault\" is accepted",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "removed from the list of pending requests",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "Fault",
      "offset": 28
    }
  ],
  "location": "AssessChangeRequestSteps.the_pending_change_request_in_a_list_of_pending_requests(String)"
});
formatter.result({
  "duration": 265176244,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "high",
      "offset": 27
    },
    {
      "val": "A",
      "offset": 48
    },
    {
      "val": "17-11-2015",
      "offset": 66
    }
  ],
  "location": "AssessChangeRequestSteps.i_accept_it_with_priority_for_developer_with_deadline(String,String,String)"
});
formatter.result({
  "duration": 87344494,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Fault",
      "offset": 20
    }
  ],
  "location": "AssessChangeRequestSteps.the_change_request_is_accepted(String)"
});
formatter.result({
  "duration": 18925454,
  "status": "passed"
});
formatter.match({
  "location": "AssessChangeRequestSteps.removed_from_the_list_of_pending_requests()"
});
formatter.result({
  "duration": 38146,
  "status": "passed"
});
formatter.after({
  "duration": 122348642,
  "status": "passed"
});
formatter.after({
  "duration": 35170221,
  "status": "passed"
});
formatter.after({
  "duration": 75350075,
  "status": "passed"
});
formatter.before({
  "duration": 3164889,
  "status": "passed"
});
formatter.before({
  "duration": 4663065,
  "status": "passed"
});
formatter.before({
  "duration": 4130287,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "accept a change request (controller)",
  "description": "",
  "id": "assess-change-request;accept-a-change-request-(controller)",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 13,
      "name": "@controller"
    }
  ]
});
formatter.step({
  "line": 15,
  "name": "the pending change request \"Fault\" in a list of pending requests",
  "keyword": "Given "
});
formatter.step({
  "line": 16,
  "name": "I accept it with priority \"high\" for developer \"A\" with deadline \"17-11-2015\"",
  "keyword": "When "
});
formatter.step({
  "line": 17,
  "name": "I should see the next pending request (if any)",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Fault",
      "offset": 28
    }
  ],
  "location": "AssessChangeRequestSteps.the_pending_change_request_in_a_list_of_pending_requests(String)"
});
formatter.result({
  "duration": 47461379,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "high",
      "offset": 27
    },
    {
      "val": "A",
      "offset": 48
    },
    {
      "val": "17-11-2015",
      "offset": 66
    }
  ],
  "location": "AssessChangeRequestSteps.i_accept_it_with_priority_for_developer_with_deadline(String,String,String)"
});
formatter.result({
  "duration": 25696933,
  "status": "passed"
});
formatter.match({
  "location": "AssessChangeRequestSteps.i_should_see_the_next_pending_request_if_any()"
});
formatter.result({
  "duration": 1230896,
  "status": "passed"
});
formatter.after({
  "duration": 50937845,
  "status": "passed"
});
formatter.after({
  "duration": 29353367,
  "status": "passed"
});
formatter.after({
  "duration": 60344890,
  "status": "passed"
});
formatter.before({
  "duration": 3917024,
  "status": "passed"
});
formatter.before({
  "duration": 4495783,
  "status": "passed"
});
formatter.before({
  "duration": 4050568,
  "status": "passed"
});
formatter.scenario({
  "line": 20,
  "name": "reject a change request",
  "description": "",
  "id": "assess-change-request;reject-a-change-request",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 19,
      "name": "@domain"
    }
  ]
});
formatter.step({
  "line": 21,
  "name": "the pending change request \"New Feature\" in a list of pending requests",
  "keyword": "Given "
});
formatter.step({
  "line": 22,
  "name": "I reject it with explanation \"feature already considered in the new release candidate\"",
  "keyword": "When "
});
formatter.step({
  "line": 23,
  "name": "the change request \"New Feature\" is rejected",
  "keyword": "Then "
});
formatter.step({
  "line": 24,
  "name": "removed from the list of pending requests",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "New Feature",
      "offset": 28
    }
  ],
  "location": "AssessChangeRequestSteps.the_pending_change_request_in_a_list_of_pending_requests(String)"
});
formatter.result({
  "duration": 46164490,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "feature already considered in the new release candidate",
      "offset": 30
    }
  ],
  "location": "AssessChangeRequestSteps.i_reject_it_with_explanation(String)"
});
formatter.result({
  "duration": 21193759,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "New Feature",
      "offset": 20
    }
  ],
  "location": "AssessChangeRequestSteps.the_change_request_is_rejected(String)"
});
formatter.result({
  "duration": 15184800,
  "status": "passed"
});
formatter.match({
  "location": "AssessChangeRequestSteps.removed_from_the_list_of_pending_requests()"
});
formatter.result({
  "duration": 28900,
  "status": "passed"
});
formatter.after({
  "duration": 58659266,
  "status": "passed"
});
formatter.after({
  "duration": 29636899,
  "status": "passed"
});
formatter.after({
  "duration": 77854205,
  "status": "passed"
});
formatter.before({
  "duration": 5093495,
  "status": "passed"
});
formatter.before({
  "duration": 4303199,
  "status": "passed"
});
formatter.before({
  "duration": 5897379,
  "status": "passed"
});
formatter.scenario({
  "line": 27,
  "name": "reject a change request (controller)",
  "description": "",
  "id": "assess-change-request;reject-a-change-request-(controller)",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 26,
      "name": "@controller"
    }
  ]
});
formatter.step({
  "line": 28,
  "name": "the pending change request \"New Feature\" in a list of pending requests",
  "keyword": "Given "
});
formatter.step({
  "line": 29,
  "name": "I reject it with explanation \"feature already considered in the new release candidate\"",
  "keyword": "When "
});
formatter.step({
  "line": 30,
  "name": "I should see the next pending request (if any)",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "New Feature",
      "offset": 28
    }
  ],
  "location": "AssessChangeRequestSteps.the_pending_change_request_in_a_list_of_pending_requests(String)"
});
formatter.result({
  "duration": 39921861,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "feature already considered in the new release candidate",
      "offset": 30
    }
  ],
  "location": "AssessChangeRequestSteps.i_reject_it_with_explanation(String)"
});
formatter.result({
  "duration": 19262908,
  "status": "passed"
});
formatter.match({
  "location": "AssessChangeRequestSteps.i_should_see_the_next_pending_request_if_any()"
});
formatter.result({
  "duration": 35437,
  "status": "passed"
});
formatter.after({
  "duration": 47695568,
  "status": "passed"
});
formatter.after({
  "duration": 31544626,
  "status": "passed"
});
formatter.after({
  "duration": 54552053,
  "status": "passed"
});
formatter.before({
  "duration": 3117238,
  "status": "passed"
});
formatter.before({
  "duration": 2192807,
  "status": "passed"
});
formatter.before({
  "duration": 3030584,
  "status": "passed"
});
formatter.scenario({
  "line": 33,
  "name": "cancel assessment",
  "description": "",
  "id": "assess-change-request;cancel-assessment",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 32,
      "name": "@controller"
    }
  ]
});
formatter.step({
  "line": 34,
  "name": "I am assessing change requests",
  "keyword": "Given "
});
formatter.step({
  "line": 35,
  "name": "I request to cancel the assessment",
  "keyword": "When "
});
formatter.step({
  "line": 36,
  "name": "I stop seeing change requests",
  "keyword": "Then "
});
formatter.match({
  "location": "AssessChangeRequestSteps.i_am_assessing_change_requests()"
});
formatter.result({
  "duration": 25541200,
  "status": "passed"
});
formatter.match({
  "location": "AssessChangeRequestSteps.i_request_to_cancel_the_assessment()"
});
formatter.result({
  "duration": 1811686,
  "status": "passed"
});
formatter.match({
  "location": "AssessChangeRequestSteps.i_stop_seeing_change_requests()"
});
formatter.result({
  "duration": 35227,
  "status": "passed"
});
formatter.after({
  "duration": 43980281,
  "status": "passed"
});
formatter.after({
  "duration": 28635032,
  "status": "passed"
});
formatter.after({
  "duration": 53539324,
  "status": "passed"
});
formatter.uri("CompleteChangeRequest.feature");
formatter.feature({
  "line": 1,
  "name": "complete change request",
  "description": "As a developer \nI want to process the change requests allocated to me\nSo that we can make progress on project development",
  "id": "complete-change-request",
  "keyword": "Feature"
});
formatter.before({
  "duration": 3582262,
  "status": "passed"
});
formatter.before({
  "duration": 3003346,
  "status": "passed"
});
formatter.before({
  "duration": 2965733,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "process a change request",
  "description": "",
  "id": "complete-change-request;process-a-change-request",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 6,
      "name": "@domain"
    }
  ]
});
formatter.step({
  "line": 8,
  "name": "I am logged in as \"alice\"",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "an approved change request \"Fault\"",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I complete the task with data \"15-11-2015\"",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "the change request \"Fault\" is removed from my list",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "alice",
      "offset": 19
    }
  ],
  "location": "CompleteRequestSteps.i_am_logged_in_as(String)"
});
formatter.result({
  "duration": 20191532,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Fault",
      "offset": 28
    }
  ],
  "location": "CompleteRequestSteps.an_approved_change_request(String)"
});
formatter.result({
  "duration": 16331808,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "15-11-2015",
      "offset": 31
    }
  ],
  "location": "CompleteRequestSteps.i_complete_the_task_with_data(String)"
});
formatter.result({
  "duration": 25431843,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Fault",
      "offset": 20
    }
  ],
  "location": "CompleteRequestSteps.the_change_request_is_removed_from_my_list(String)"
});
formatter.result({
  "duration": 21870711,
  "status": "passed"
});
formatter.after({
  "duration": 70698551,
  "status": "passed"
});
formatter.after({
  "duration": 29208589,
  "status": "passed"
});
formatter.after({
  "duration": 56935252,
  "status": "passed"
});
formatter.before({
  "duration": 3693072,
  "status": "passed"
});
formatter.before({
  "duration": 4384265,
  "status": "passed"
});
formatter.before({
  "duration": 4284322,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "process a change request (controller)",
  "description": "",
  "id": "complete-change-request;process-a-change-request-(controller)",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 13,
      "name": "@controller"
    }
  ]
});
formatter.step({
  "line": 15,
  "name": "I am logged in as \"alice\"",
  "keyword": "Given "
});
formatter.step({
  "line": 16,
  "name": "an approved change request \"Fault\"",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "I complete the task with data \"15-11-2015\"",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "I should get the next approved request allocated to me",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "alice",
      "offset": 19
    }
  ],
  "location": "CompleteRequestSteps.i_am_logged_in_as(String)"
});
formatter.result({
  "duration": 15359059,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Fault",
      "offset": 28
    }
  ],
  "location": "CompleteRequestSteps.an_approved_change_request(String)"
});
formatter.result({
  "duration": 15210909,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "15-11-2015",
      "offset": 31
    }
  ],
  "location": "CompleteRequestSteps.i_complete_the_task_with_data(String)"
});
formatter.result({
  "duration": 18452615,
  "status": "passed"
});
formatter.match({
  "location": "CompleteRequestSteps.i_should_get_the_next_approved_request_allocated_to_me()"
});
formatter.result({
  "duration": 1356970,
  "status": "passed"
});
formatter.after({
  "duration": 42400584,
  "status": "passed"
});
formatter.after({
  "duration": 30062178,
  "status": "passed"
});
formatter.after({
  "duration": 48218894,
  "status": "passed"
});
formatter.uri("RequestChange.feature");
formatter.feature({
  "line": 1,
  "name": "request change",
  "description": "As a developer\nI want to create a change request\nSo that issues or request new features can be reported",
  "id": "request-change",
  "keyword": "Feature"
});
formatter.before({
  "duration": 3128548,
  "status": "passed"
});
formatter.before({
  "duration": 2637798,
  "status": "passed"
});
formatter.before({
  "duration": 2658249,
  "status": "passed"
});
formatter.background({
  "line": 6,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 7,
  "name": "a SCI \"SCI_1\"",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "a head version \"version_2\"",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "SCI_1",
      "offset": 7
    }
  ],
  "location": "RequestChangeSteps.a_SCI(String)"
});
formatter.result({
  "duration": 13794076,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "version_2",
      "offset": 16
    }
  ],
  "location": "RequestChangeSteps.a_head_version(String)"
});
formatter.result({
  "duration": 16158638,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "report a fault",
  "description": "",
  "id": "request-change;report-a-fault",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 10,
      "name": "@domain"
    }
  ]
});
formatter.step({
  "line": 12,
  "name": "a problem description \"Fault\"",
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "a proposed solution \"Missing dependency\"",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "I request a change request for reporting a fault",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "the system stores the fault request \"Fault\" for the head version \"version_2\" of \"SCI_1\" with solution \"Missing dependency\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Fault",
      "offset": 23
    }
  ],
  "location": "RequestChangeSteps.a_problem_description(String)"
});
formatter.result({
  "duration": 53090,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Missing dependency",
      "offset": 21
    }
  ],
  "location": "RequestChangeSteps.a_proposed_solution(String)"
});
formatter.result({
  "duration": 42255,
  "status": "passed"
});
formatter.match({
  "location": "RequestChangeSteps.i_request_a_change_request_for_reporting_a_fault()"
});
formatter.result({
  "duration": 21318331,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Fault",
      "offset": 37
    },
    {
      "val": "version_2",
      "offset": 66
    },
    {
      "val": "SCI_1",
      "offset": 81
    },
    {
      "val": "Missing dependency",
      "offset": 103
    }
  ],
  "location": "RequestChangeSteps.the_system_stores_the_fault_request_for_the_head_version_of_with_solution(String,String,String,String)"
});
formatter.result({
  "duration": 12038770,
  "status": "passed"
});
formatter.after({
  "duration": 37365438,
  "status": "passed"
});
formatter.after({
  "duration": 21822775,
  "status": "passed"
});
formatter.after({
  "duration": 59888927,
  "status": "passed"
});
formatter.before({
  "duration": 2576944,
  "status": "passed"
});
formatter.before({
  "duration": 2656076,
  "status": "passed"
});
formatter.before({
  "duration": 3020643,
  "status": "passed"
});
formatter.background({
  "line": 6,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 7,
  "name": "a SCI \"SCI_1\"",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "a head version \"version_2\"",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "SCI_1",
      "offset": 7
    }
  ],
  "location": "RequestChangeSteps.a_SCI(String)"
});
formatter.result({
  "duration": 16096485,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "version_2",
      "offset": 16
    }
  ],
  "location": "RequestChangeSteps.a_head_version(String)"
});
formatter.result({
  "duration": 15998808,
  "status": "passed"
});
formatter.scenario({
  "line": 18,
  "name": "report a fault (controller)",
  "description": "",
  "id": "request-change;report-a-fault-(controller)",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 17,
      "name": "@controller"
    }
  ]
});
formatter.step({
  "line": 19,
  "name": "a problem description \"Fault\"",
  "keyword": "Given "
});
formatter.step({
  "line": 20,
  "name": "a proposed solution \"Missing dependency\"",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "I request a change request for reporting a fault",
  "keyword": "When "
});
formatter.step({
  "line": 22,
  "name": "The system shows a summary of the change request",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Fault",
      "offset": 23
    }
  ],
  "location": "RequestChangeSteps.a_problem_description(String)"
});
formatter.result({
  "duration": 54453,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Missing dependency",
      "offset": 21
    }
  ],
  "location": "RequestChangeSteps.a_proposed_solution(String)"
});
formatter.result({
  "duration": 39505,
  "status": "passed"
});
formatter.match({
  "location": "RequestChangeSteps.i_request_a_change_request_for_reporting_a_fault()"
});
formatter.result({
  "duration": 22329113,
  "status": "passed"
});
formatter.match({
  "location": "RequestChangeSteps.the_system_shows_a_summary_of_the_change_request()"
});
formatter.result({
  "duration": 48269,
  "status": "passed"
});
formatter.after({
  "duration": 46613649,
  "status": "passed"
});
formatter.after({
  "duration": 24071119,
  "status": "passed"
});
formatter.after({
  "duration": 59778413,
  "status": "passed"
});
formatter.before({
  "duration": 1970835,
  "status": "passed"
});
formatter.before({
  "duration": 1814281,
  "status": "passed"
});
formatter.before({
  "duration": 1932032,
  "status": "passed"
});
formatter.background({
  "line": 6,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 7,
  "name": "a SCI \"SCI_1\"",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "a head version \"version_2\"",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "SCI_1",
      "offset": 7
    }
  ],
  "location": "RequestChangeSteps.a_SCI(String)"
});
formatter.result({
  "duration": 15659777,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "version_2",
      "offset": 16
    }
  ],
  "location": "RequestChangeSteps.a_head_version(String)"
});
formatter.result({
  "duration": 15515657,
  "status": "passed"
});
formatter.scenario({
  "line": 26,
  "name": "request a new feature",
  "description": "",
  "id": "request-change;request-a-new-feature",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 25,
      "name": "@domain"
    }
  ]
});
formatter.step({
  "line": 27,
  "name": "a problem description \"New Feature\"",
  "keyword": "Given "
});
formatter.step({
  "line": 28,
  "name": "a proposed solution \"Extension of Module A\"",
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "I request a new feature",
  "keyword": "When "
});
formatter.step({
  "line": 30,
  "name": "the system stores the new feature request \"New Feature\" for the head version \"version_2\" of \"SCI_1\" with solution \"Extension of Module A\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "New Feature",
      "offset": 23
    }
  ],
  "location": "RequestChangeSteps.a_problem_description(String)"
});
formatter.result({
  "duration": 65372,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Extension of Module A",
      "offset": 21
    }
  ],
  "location": "RequestChangeSteps.a_proposed_solution(String)"
});
formatter.result({
  "duration": 311054,
  "status": "passed"
});
formatter.match({
  "location": "RequestChangeSteps.i_request_a_new_feature()"
});
formatter.result({
  "duration": 23294425,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "New Feature",
      "offset": 43
    },
    {
      "val": "version_2",
      "offset": 78
    },
    {
      "val": "SCI_1",
      "offset": 93
    },
    {
      "val": "Extension of Module A",
      "offset": 115
    }
  ],
  "location": "RequestChangeSteps.the_system_stores_the_new_feature_request_for_the_head_version_of_with_solution(String,String,String,String)"
});
formatter.result({
  "duration": 13351336,
  "status": "passed"
});
formatter.after({
  "duration": 44044851,
  "status": "passed"
});
formatter.after({
  "duration": 23793162,
  "status": "passed"
});
formatter.after({
  "duration": 57319765,
  "status": "passed"
});
formatter.before({
  "duration": 2642135,
  "status": "passed"
});
formatter.before({
  "duration": 2511941,
  "status": "passed"
});
formatter.before({
  "duration": 2411605,
  "status": "passed"
});
formatter.background({
  "line": 6,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 7,
  "name": "a SCI \"SCI_1\"",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "a head version \"version_2\"",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "SCI_1",
      "offset": 7
    }
  ],
  "location": "RequestChangeSteps.a_SCI(String)"
});
formatter.result({
  "duration": 15328151,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "version_2",
      "offset": 16
    }
  ],
  "location": "RequestChangeSteps.a_head_version(String)"
});
formatter.result({
  "duration": 15032721,
  "status": "passed"
});
formatter.scenario({
  "line": 33,
  "name": "request a new feature (controller)",
  "description": "",
  "id": "request-change;request-a-new-feature-(controller)",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 32,
      "name": "@controller"
    }
  ]
});
formatter.step({
  "line": 34,
  "name": "a problem description \"New Feature\"",
  "keyword": "Given "
});
formatter.step({
  "line": 35,
  "name": "a proposed solution \"Extension of Module A\"",
  "keyword": "And "
});
formatter.step({
  "line": 36,
  "name": "I request a new feature",
  "keyword": "When "
});
formatter.step({
  "line": 37,
  "name": "The system shows a summary of the change request",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "New Feature",
      "offset": 23
    }
  ],
  "location": "RequestChangeSteps.a_problem_description(String)"
});
formatter.result({
  "duration": 49877,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Extension of Module A",
      "offset": 21
    }
  ],
  "location": "RequestChangeSteps.a_proposed_solution(String)"
});
formatter.result({
  "duration": 36479,
  "status": "passed"
});
formatter.match({
  "location": "RequestChangeSteps.i_request_a_new_feature()"
});
formatter.result({
  "duration": 21488415,
  "status": "passed"
});
formatter.match({
  "location": "RequestChangeSteps.the_system_shows_a_summary_of_the_change_request()"
});
formatter.result({
  "duration": 35502,
  "status": "passed"
});
formatter.after({
  "duration": 45124204,
  "status": "passed"
});
formatter.after({
  "duration": 25678300,
  "status": "passed"
});
formatter.after({
  "duration": 60029413,
  "status": "passed"
});
});