
angular.module('salao')
  .controller('funcionarioCtrl', function($scope,$http, ngNotify, RestSrv, SERVICE_PATH) {

    $scope.fileupload = {};
    $scope.fileuploads = [];
    $scope.permissions = [];
    $scope.showAddEditUser = false;



            ngNotify.config({
              theme: 'pastel'
            });


    // Show the form used to edit or add users.
    $scope.show = function() {
      $scope.showAddEditUser = true;
    };

    // Hide the form used to edit or add users.
    $scope.hide = function() {
      $scope.showAddEditUser = false;
      $scope.fileupload = {};
    };



    // Manage CRUD operations.
    var fileUrl = SERVICE_PATH.PRIVATE_PATH + '/funcionario';



    $scope.editFile = function(fileupload) {
      $scope.fileupload = angular.copy(fileupload);
      $scope.show();
    };

    $scope.deleteFile = function(fileupload) {
      RestSrv.delete(fileUrl, fileupload, function() {
        $scope.fileuploads.splice($scope.fileuploads.indexOf(fileupload), 1);
        ngNotify.set('Fileupload \'' + fileupload.name + '\' deleted.', 'success');
      });
    };


    $scope.updateLinkImageEdit = function(file){
        var arq = file.split(',');
        $scope.fileuploadEdit.mimeType = arq[0];
        $scope.fileuploadEdit.file = arq[1];
    };




    $scope.updateLinkImage = function(file){
        var arq = file.split(',');
        $scope.fileupload.mimeType = arq[0];
        $scope.fileupload.file = arq[1];
    };






    $scope.saveFile = function(fileupload) {
      if (fileupload.id) {
        RestSrv.edit(fileUrl, fileupload, function() {


          for (var i = 0; i < $scope.fileuploads.length; i++) {
            if ($scope.fileuploads[i].id === fileupload.id) { //=== verifica id e o objeto
              $scope.fileuploads[i] = fileupload;
            }
          }

          $scope.hide();// para esconder o forme
          ngNotify.set('Fileupload \'' + fileupload.name + '\' updated.', 'success');



        });


      } else {
        RestSrv.add(fileUrl, fileupload, function(newFile) {
          $scope.fileuploads.push(newFile);
          $scope.hide();
          ngNotify.set('Fileupload \'' + fileupload.name + '\' added.', 'success');



        });

      }
    };






    // Request all data (formularios).
    RestSrv.find(fileUrl, function(data) {
      $scope.fileuploads = data;

         console.log($scope.fileuploads);

       $scope.fileuploadEdit =  $scope.fileuploads[0];
      ngNotify.set('Loaded fileuploads with success.', 'success');
    });






       var permissionUrl =  SERVICE_PATH.PRIVATE_PATH + '/permission';

         RestSrv.find(permissionUrl, function(data) {


             $scope.permissions = data;


      });





  });
