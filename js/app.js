angular.module('starter', ['ionic', 'starter.controllers', 'starter.services'])

.run(function($ionicPlatform) {
  $ionicPlatform.ready(function() {
    // Hide the accessory bar by default (remove this to show the accessory bar above the keyboard
    // for form inputs)
    if (window.cordova && window.cordova.plugins && window.cordova.plugins.Keyboard) {
      cordova.plugins.Keyboard.hideKeyboardAccessoryBar(true);
    }
    if (window.StatusBar) {
      // org.apache.cordova.statusbar required
      StatusBar.styleLightContent();
    }
  });
})

.config(function($stateProvider, $urlRouterProvider) {

  $stateProvider
  .state('tab', {
    url: "/tab",
    abstract: true,
    templateUrl: "templates/tabs.html"
  })

  // Each tab has its own nav history stack:

  .state('tab.sobre', {
    url: '/sobre',
    views: {
      'tab-dash': {
        templateUrl: 'templates/tab-sobre.html',
        controller: 'SobreCtrl'
      }
    }
  })

  .state('tab.empresas', {
      url: '/empresas',
      views: {
        'tab-chats': {
          templateUrl: 'templates/tab-empresas.html',
          controller: 'EmpresasCtrl'
        }
      }
    })
    .state('tab.empresas-detalhe', {
      url: '/empresas/:chatId',
      views: {
        'tab-chats': {
          templateUrl: 'templates/empresas-detalhe.html',
          controller: 'EmpresasDetalheCtrl'
        }
      }
    })

  .state('tab.palestrantes', {
    url: '/palestrantes',
    views: {
      'tab-account': {
        templateUrl: 'templates/tab-palestrantes.html',
        controller: 'PalestrantesCtrl'
      }
    }
  })
  
  .state('tab.palestrantes-detalhe', {
    url: '/palestrantes/:chatId',
    views: {
      'tab-account': {
        templateUrl: 'templates/palestrantes-detalhe.html',
        controller: 'PalestrantesDetalheCtrl'
      }
    }
  });

  $urlRouterProvider.otherwise('/tab/sobre');
});
