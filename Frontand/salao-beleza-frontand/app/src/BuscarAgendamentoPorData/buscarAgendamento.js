
angular.module('salao')
  .controller('dataCtrl', function($scope,$http, ngNotify, RestSrv, SERVICE_PATH) {
    $scope.busca = {};
    $scope.buscas = [];


    ngNotify.config({
      theme: 'pastel'
    });



    // Manage CRUD operations.
    var buscaDataUrl = SERVICE_PATH.PRIVATE_PATH + '/buscadata';

       $scope.msg=('Nome das Imagens: ');


    // Busca a imagem pelo nome

    $scope.buscaFuncionario = function(busca) {
      RestSrv.findBucaData(buscaDataUrl, busca, function(newBuscaData) {
          $scope.buscas = newBuscaData;
        });
    };







  });
