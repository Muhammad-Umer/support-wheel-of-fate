
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Support Wheel of Fate</title>
    <script src="https://canvasjs.com/assets/script/canvasjs.min.js" type="text/javascript" ></script>
    <script type="text/javascript" src="/lib/jquery.min.js"></script>
    <script type="text/javascript" src="lib/angular.js"></script>
    <script type="text/javascript" src="lib/angular-chosen.min.js"></script>
    <script type="text/javascript" src="lib/chosen.jquery.min.js"></script>
    <script type="text/javascript" src="lib/ui-bootstrap-tpls-2.5.0.min.js"></script>
    <script type="text/javascript" src="js/main.js"></script>
    <link href="css/bootstrap-3-3.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/main.css" rel="stylesheet">
    <link href="css/chosen.min.css" rel="stylesheet">

    <link rel="stylesheet"; href="https://unpkg.com/ng-table@2.0.2/bundles/ng-table.min.css">
    <script src="https://unpkg.com/ng-table@2.0.2/bundles/ng-table.min.js"></script>
</head>

<body ng-app="supportWheelOfFateApp">
<div class="headerWrap">
          <span class="headingWrap">
            <h1 class="heading">Support Wheel of Fate</h1>
          </span>
    <span>
            <img class="wheelImg" src="assets/support-wheel.jpg">
          </span>
</div>
<div class="mainWrap" ng-controller = "supportWheelOfFateController as swfCtrl">
    <div class="calenderWrap">
        <pre><em class="selectionHeading">Please select a date</em></pre>
        <div class="calander">
            <div uib-datepicker ng-model-options="{timezone: 'utc'}" ng-model="swfCtrl.date" class="well well-sm" ng-change="swfCtrl.dateChange()"
                 datepicker-options="swfCtrl.dateOptions"></div>
        </div>
        <div class="mainButtonWrap">
            <button class="mainButton" ng-click="swfCtrl.generate()" >Generate Schedule</button>
            <button class="mainButton mainButtonDanger" ng-click="swfCtrl.delete()" >Delete Schedule</button>
        </div>

        <hr />
    </div>
    <div class="gridWrap">
            <span class="label label-default noScheduleMessage" ng-show="swfCtrl.tableData.length == 0">
              No schedule available. Please generate schedule for the seleted date.
            </span>
        <table ng-table="swfCtrl.tableParams" class="table" show-filter="false" ng-show="swfCtrl.tableData.length != 0">
            <tr ng-repeat="shift in swfCtrl.tableData">
                <td title="'Shift Id'" filter="{ shiftId: 'number'}" sortable="'shiftId'">{{shift.shiftId}}</td>
                <td title="'Engineer Id'" filter="{ engineerId: 'number'}" sortable="'engineerId'">{{shift.engineerDto.engineerId}}</td>
                <td title="'First Name'" filter="{ firstName: 'text'}" sortable="'firstName'">{{shift.engineerDto.firstName}}</td>
                <td title="'Last Name'" filter="{ lastName: 'text'}" sortable="'lastName'">{{shift.engineerDto.lastName}}</td>
                <td title="'Email'" filter="{ email: 'text'}" sortable="'email'">{{shift.engineerDto.email}}</td>
                <td title="'Shift Date'" filter="{ shiftDate: 'text'}" sortable="'shiftDate'">{{shift.shiftDate}}</td>

            </tr>
        </table>
    </div>
</div>
</body>
</html>
