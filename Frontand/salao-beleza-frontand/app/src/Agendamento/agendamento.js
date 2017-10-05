'use strict';

angular.module('salao')
  .controller('AgendaCtrl', function($scope, ngNotify, RestSrv, SERVICE_PATH) {

    $scope.ag = {};
    $scope.ags = [];

    $scope.p = {};
    $scope.ps = [];


    $scope.m = {};
    $scope.ms = [];

    $scope.h = {};
    $scope.hs = [];



  var funcionarioUrl =  SERVICE_PATH.PRIVATE_PATH + '/funcionario';
  var mostrarAgendamentoUrl = SERVICE_PATH.PRIVATE_PATH + '/mostrarAgendamento';
  var agendamentoUrl = SERVICE_PATH.PRIVATE_PATH + '/agendamento';
  var horarioUrl = SERVICE_PATH.PRIVATE_PATH + '/horario';




              RestSrv.find(funcionarioUrl,function(data) {
                $scope.ps = data;
                ngNotify.set('Loaded ps with success.', 'success');
              });

              RestSrv.find(mostrarAgendamentoUrl,function(data) {
                  $scope.ms = data;
                  ngNotify.set('Loaded ms with success.', 'success');
                });

                RestSrv.find(horarioUrl,function(data) {
                  $scope.hs = data;
                  ngNotify.set('Loaded hs with success.', 'success');
                });




    $scope.showA = false;

    // Show the form used to edit or add packagees.
    $scope.show = function() {
      $scope.showA= true;
    };

    // Hide the form used to edit or add packagees.
    $scope.hide = function() {
      $scope.showA = false;
      $scope.ag = {};
    };

    // Manage CRUD operations.


    $scope.editAgendamento = function(ag) {
      $scope.ag = angular.copy(ag);
      $scope.show();
    };

    $scope.deleteAgendamento = function(ag) {
      RestSrv.delete(agendamentoUrl,ag, function() {
        $scope.ags.splice($scope.ags.indexOf(ag), 1);
        ngNotify.set('Agendamento \'' + ag.empresa + '\' deleted.', 'success');
      });
    };

    $scope.saveAgendamento = function(ag) {
      if (ag.id) {
        RestSrv.edit(agendamentoUrl, ag, function() {
          for (var i = 0; i < $scope.ags.length; i++) {
            if ($scope.ags[i].id === ag.id) {
              $scope.ags[i] = ag;
            }
          }

          $scope.hide();
          ngNotify.set('Agendamento \'' + ag.empresa + '\' updated.', 'success');
        });
      } else {
        RestSrv.add(agendamentoUrl, ag, function(newAgendamento) {
          $scope.ags.push(newAgendamento);
          $scope.hide();
          ngNotify.set('Agendamento\'' + ag.empresa + '\' added.', 'success');
        });
      }
    };

    // Request all data (packagees).
    RestSrv.find(agendamentoUrl, function(data) {
      $scope.ags = data;
      ngNotify.set('Loaded ags with success.', 'success');
    });

  });
