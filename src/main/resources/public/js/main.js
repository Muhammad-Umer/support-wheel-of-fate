/**
 * Created by umer on 12/5/2017.
 */
var supportWheelOfFateApp = angular.module('supportWheelOfFateApp', ['localytics.directives', 'ui.bootstrap', "ngTable"]);

supportWheelOfFateApp.controller("supportWheelOfFateController",
    ['$scope','$interval', 'NgTableParams', 'supportWheelOfFateService',
    function ($scope, $interval, NgTableParams, supportWheelOfFateService) {
    var swfCtrl = this;
    swfCtrl.date = new Date();
    swfCtrl.tableData = [];
    swfCtrl.tableParams = new NgTableParams({}, { dataset: swfCtrl.tableData});

    swfCtrl.dateOptions = {
      showWeeks: false
    };

    swfCtrl.dateChange = function(){
        console.log(swfCtrl.date);
        swfCtrl.getSchedule(swfCtrl.date.getTime());
    };

    swfCtrl.generate = function(){
        swfCtrl.generateSchedule(swfCtrl.date.getTime());
    };

    swfCtrl.delete = function(){
        swfCtrl.deleteSchedule(swfCtrl.date.getTime());
    };

    swfCtrl.generateSchedule = function(timeStamp){
      supportWheelOfFateService.generateSchedule(timeStamp).then(function(resp){
          if(resp.data.status == 200 && resp.data.data == "The schedule is generated successfully"){
              swfCtrl.getSchedule(timeStamp);
          }
      });
    };

    swfCtrl.getSchedule = function(timeStamp){
      supportWheelOfFateService.getSchedule(timeStamp).then(function(resp){
          if(resp.data.status == 200){
              swfCtrl.tableData = resp.data.data.shiftDtos;
          }
      });
    };

    swfCtrl.deleteSchedule = function(timeStamp){
        supportWheelOfFateService.deleteSchedule(timeStamp).then(function(resp){
             console.log(resp);
             swfCtrl.getSchedule(timeStamp);
        });
    };

    swfCtrl.getSchedule(swfCtrl.date.getTime());

}]);

supportWheelOfFateApp.service("supportWheelOfFateService", ['$http', '$q', function ($http, $q) {
    var supportWheelOfFateService = this;
    supportWheelOfFateService.generateSchedule = function (timeStamp) {
        var deferred = $q.defer();
        $http({
            method: 'POST',
            url: '../../v1/schedule/generate/' + timeStamp
        }).then(function (response){
            deferred.resolve(response);
        },function (error){
            deferred.reject(error);
        });
        return deferred.promise;
    };

    supportWheelOfFateService.getSchedule = function (timeStamp) {
        var deferred = $q.defer();
        $http({
            method: 'GET',
            url: '../../v1/schedule/get/' + timeStamp
        }).then(function (response){
            deferred.resolve(response);
        },function (error){
            deferred.reject(error);
        });
        return deferred.promise;
    };

    supportWheelOfFateService.deleteSchedule = function (timeStamp) {
        var deferred = $q.defer();
        $http({
            method: 'DELETE',
            url: '../../v1/schedule/delete/' + timeStamp
        }).then(function (response){
            deferred.resolve(response);
        },function (error){
            deferred.reject(error);
        });
        return deferred.promise;
    };
}]);
