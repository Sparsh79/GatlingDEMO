var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "100",
        "ok": "100",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "451",
        "ok": "451",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "803",
        "ok": "803",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "638",
        "ok": "638",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "87",
        "ok": "87",
        "ko": "-"
    },
    "percentiles1": {
        "total": "612",
        "ok": "612",
        "ko": "-"
    },
    "percentiles2": {
        "total": "689",
        "ok": "689",
        "ko": "-"
    },
    "percentiles3": {
        "total": "788",
        "ok": "788",
        "ko": "-"
    },
    "percentiles4": {
        "total": "801",
        "ok": "801",
        "ko": "-"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 97,
        "percentage": 97
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 3,
        "percentage": 3
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 0,
        "percentage": 0
    },
    "group4": {
        "name": "failed",
        "count": 0,
        "percentage": 0
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "50",
        "ok": "50",
        "ko": "-"
    }
},
contents: {
"req_individualreque-93aaa": {
        type: "REQUEST",
        name: "IndividualRequest",
path: "IndividualRequest",
pathFormatted: "req_individualreque-93aaa",
stats: {
    "name": "IndividualRequest",
    "numberOfRequests": {
        "total": "100",
        "ok": "100",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "451",
        "ok": "451",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "803",
        "ok": "803",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "638",
        "ok": "638",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "87",
        "ok": "87",
        "ko": "-"
    },
    "percentiles1": {
        "total": "612",
        "ok": "612",
        "ko": "-"
    },
    "percentiles2": {
        "total": "689",
        "ok": "689",
        "ko": "-"
    },
    "percentiles3": {
        "total": "788",
        "ok": "788",
        "ko": "-"
    },
    "percentiles4": {
        "total": "801",
        "ok": "801",
        "ko": "-"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 97,
        "percentage": 97
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 3,
        "percentage": 3
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 0,
        "percentage": 0
    },
    "group4": {
        "name": "failed",
        "count": 0,
        "percentage": 0
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "50",
        "ok": "50",
        "ko": "-"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
