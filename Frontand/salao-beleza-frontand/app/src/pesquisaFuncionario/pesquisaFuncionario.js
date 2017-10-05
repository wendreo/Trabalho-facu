
angular.module('salao')
  .controller('pesquisaFuncionarioCtrl', function($scope,$http, ngNotify, RestSrv, SERVICE_PATH) {
    $scope.f = {};
    $scope.fs = [];

    $scope.showA = false;

    $scope.show = function() {
    $scope.showA= true;
  };

  $scope.hide = function() {
    $scope.showA = false;
    $scope.f = {};
  };


    ngNotify.config({
      theme: 'pastel'
    });

    var apUrl =  SERVICE_PATH.PRIVATE_PATH + '/funcionario';


    RestSrv.find(apUrl,function(data) {
      $scope.fs = data;
      ngNotify.set('Loaded aps with success.', 'success');
    });






  });
