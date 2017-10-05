'use strict';

var BASE_URL = 'http://localhost:8080/api';

angular.module('salao', ['checklist-model', 'ngNotify', 'ngRoute', 'ngCookies', 'ngStorage'])
    .constant('SERVICE_PATH', {
      'ROOT_PATH': BASE_URL,
      'PUBLIC_PATH': BASE_URL + '/public',
      'PRIVATE_PATH': BASE_URL + '/private'
    })
  .config(function($routeProvider) {
    $routeProvider.
      when('/', {
        templateUrl: 'src/home/home.html',
        controller: 'HomeCtrl'
      })
      .when('/login', {
        templateUrl: 'src/login/login.html',
        controller: 'LoginCtrl'
      })

      .when('/user', {
        templateUrl: 'src/user/user.html',
        controller: 'UserCtrl'
      })
      .when('/userTable', {
        templateUrl: 'src/userTable/usertable.html',
        controller: 'UserTableCtrl'
      })
      .when('/editUser', {
          templateUrl: 'src/editUser/editUser.html',
          controller: 'editUserCtrl'
        })

      .when('/Funcionario', {
      templateUrl: 'src/Funcionario/funcionario.html',
      controller: 'funcionarioCtrl'
    })

    .when('/pesquisaFuncionario', {
      templateUrl: 'src/pesquisaFuncionario/pesquisaFuncionario.html',
      controller: 'pesquisaFuncionarioCtrl'
    })

    .when('/Cadastro', {
      templateUrl: 'src/Cadastro/cadastro.html',
      controller: 'cadastroCtrl'
    })



    .when('/Agendamento', {
      templateUrl: 'src/Agendamento/agendamento.html',
      controller: 'AgendaCtrl'
    })


    .when('/MostrarAgendamento', {
      templateUrl: 'src/MostrarAgendamento/mostrarAgendamento.html',
      controller: 'AgCtrl'
    })


    .when('/BuscarAgendamentoPorData', {
      templateUrl: 'src/BuscarAgendamentoPorData/buscarAgendamento.html',
      controller: 'dataCtrl'
    })


      .otherwise({
        redirectTo: '/'
      });


      })
      .config(function($httpProvider) {
        $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
        $httpProvider.defaults.withCredentials = true;
        $httpProvider.interceptors.push('httpRequestInterceptor');
      })
      .run(function($rootScope, ngNotify, LoginLogoutSrv) {
        $rootScope.authDetails = { name: '', authenticated: false, permissions: [] };

        ngNotify.config({
          theme: 'pastel'
        });

        LoginLogoutSrv.verifyAuth();

        })

        .directive('slider', function ($timeout) {
return {
 restrict: 'AE',
replace: true,
scope:{
 images: '='
},
 link: function (scope) {

 scope.currentIndex=0;

 scope.next=function(){
   if(scope.currentIndex<scope.images.length-1){
    scope.currentIndex++;
   }else{
     scope.currentIndex=0;
   }
 };

 scope.prev=function(){
   if( scope.currentIndex>0){
     scope.currentIndex--;
   }else{
     scope.currentIndex=scope.images.length-1;
   }
 };

 scope.$watch('currentIndex',function(){
   scope.image.forEach(function(image){
     image.visible=false;
   });
   scope.images[scope.currentIndex].visible=true;
 });

 /* Start: For Automatic slideshow*/

 var timer;

 var sliderFunc=function(){
   timer=$timeout(function(){
     scope.next();
     timer=$timeout(sliderFunc,5000);
   },5000);
 };

 sliderFunc();

 scope.$on('$destroy',function(){
   $timeout.cancel(timer);
 });

 /* End : For Automatic slideshow*/

},templateUrl:'src/img/img.html'
/* */




  };


});
