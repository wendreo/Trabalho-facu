'use strict';

angular.module('salao')
  .controller('UserCtrl', function($scope, ngNotify, RestSrv, SERVICE_PATH) {


              $scope.user_id = {};
              $scope.user_ids = [];

              var ApartamentoUrl =  SERVICE_PATH.PRIVATE_PATH + '/apartamento';


              RestSrv.find(ApartamentoUrl,function(data) {
                $scope.user_ids = data;
                ngNotify.set('Loaded user_ids with success.', 'success');
              });




    $scope.user = {};
    $scope.users = [];
    $scope.permissions = [];
    $scope.showAddEditUser = false;

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
    var userUrl = SERVICE_PATH.PRIVATE_PATH + '/usuarios';


    $scope.updateLinkImage = function(file){
        var arq = file.split(',');
        $scope.user.mimeType = arq[0];
        $scope.user.file = arq[1];
    };


    $scope.editUser = function(user) {
      $scope.user = angular.copy(user);
      $scope.show();
    };

    $scope.deleteUser = function(user) {
      RestSrv.delete(userUrl, user, function() {
        $scope.users.splice($scope.users.indexOf(user), 1);
        ngNotify.set('User \'' + user.name + '\' deleted.', 'success');
      });
    };

    $scope.saveUser = function(user) {
      if (user.id) {
        RestSrv.edit(userUrl, user, function() {
          delete user.password;

          for (var i = 0; i < $scope.users.length; i++) {
            if ($scope.users[i].id === user.id) {
              $scope.users[i] = user;
            }
          }

          $scope.hide();
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

    // Request all data (permission and user).
    var permissionUrl = SERVICE_PATH.PRIVATE_PATH + '/permission';

    RestSrv.find(permissionUrl, function(data) {
      $scope.permissions = data;

      RestSrv.find(userUrl, function(data) {
        $scope.users = data;
        ngNotify.set('Loaded users with success.', 'success');
      });
    });

  });
