'use strict';

angular.module('salao')
  .controller('AgCtrl', function($scope, ngNotify, RestSrv, SERVICE_PATH) {


    $scope.agenda = {};
    $scope.agendas = [];


    var agendamentoUrl = SERVICE_PATH.PRIVATE_PATH + '/mostrarAgendamento';

            RestSrv.find(agendamentoUrl,function(data) {
                $scope.agendas = data;
                ngNotify.set('Loaded agendas with success.', 'success');
              });








  });
