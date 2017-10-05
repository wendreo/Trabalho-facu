'use strict';

angular.module('salao')
  .controller('cadastroCtrl', function($scope, ngNotify, RestSrv, SERVICE_PATH) {





    $scope.user = {};
    $scope.users = [];

    $scope.permissao = {};
    $scope.showAddEditUser = false;


    ngNotify.config({
      theme: 'pastel'
    });

      $scope.msg = 'Para se cadastrar digite  os dados requeridos nos campos abaixo!'

    // Show the form used to edit or add users.
    $scope.show = function() {
      $scope.showAddEditUser = true;
    };

    // Hide the form used to edit or add users.
    $scope.hide = function() {
      $scope.showAddEditUser = false;
      $scope.user = {};
    };

    // Manage CRUD operations.
    var userUrl =  SERVICE_PATH.PUBLIC_PATH + '/clientes';




    $scope.updateLinkImageEdit = function(file){
        var arq = file.split(',');
        $scope.userEdit.mimeType = arq[0];
        $scope.userEdit.file = arq[1];
    };




    $scope.updateLinkImage = function(file){
        var arq = file.split(',');
        $scope.user.mimeType = arq[0];
        $scope.user.file = arq[1];
    };


    $scope.saveUser = function(user) {





      if (user.id ) {


        RestSrv.edit(userUrl, user, function() {
          delete user.password;

          for (var i = 0; i < $scope.users.length; i++) {
            if ($scope.users[i].id === user.id) { //=== verifica id e o objeto
              $scope.users[i] = user;



            }

                 //  $scope.user = {};
                     //    if($scope.permission === ''){
                     //       $scope.user = {'permissions': [{'role': 'ROLE_USER'}]};
                     //    }else{
                       //    $scope.user = {'permissions': [$scope.permission]};
                     //    }






          }



          $scope.hide();// para esconder o forme
          ngNotify.set('User \'' + user.name + '\' updated.', 'success');
        });


      } else {



        RestSrv.add(userUrl, user, function(newUser) {
          $scope.users.push(newUser);
          $scope.hide();
          ngNotify.set('User \'' + user.name + '\' added.', 'success');
        });
      }
    };



    RestSrv.find(userUrl,function(data) {
      $scope.users = data;
      ngNotify.set('Loaded users with success.', 'success');
    });


    // Request all data (permission and user).



   var permissionUrl =  SERVICE_PATH.PUBLIC_PATH   + '/permissionclientes/findRole/ROLE_CLIENTE';

     RestSrv.findCadastro(permissionUrl, function(data) {


         $scope.permissions = data;


  });






  });
