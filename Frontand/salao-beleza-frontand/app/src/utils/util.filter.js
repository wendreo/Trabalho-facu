'use strict';

angular.module('salao')
  .filter('formatPermission', function() {
    return function(input) {
      switch (input) {
        case 'ROLE_ADMIN':
          return 'Administrador';
        break;
          case 'ROLE_FUNCIONARIO':
          return 'Funcionario';
        break;

        case 'ROLE_CLIENTE':
          return 'Cliente';
        break;

        default:
          return 'Unknown';
        break;
      };


    };



  });
