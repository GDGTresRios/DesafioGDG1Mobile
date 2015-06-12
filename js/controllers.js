angular.module('starter.controllers', [])

.controller('SobreCtrl', function($scope) {})

.controller('EmpresasCtrl', function($scope, Empresas) {
  $scope.empresas = Empresas.all();
})

.controller('EmpresasDetalheCtrl', function($scope, $stateParams, Empresas) {
  $scope.chat = Empresas.get($stateParams.chatId);
})

.controller('PalestrantesCtrl', function($scope, Palestrantes) {
  $scope.palestrantes = Palestrantes.all();
})

.controller('PalestrantesDetalheCtrl', function($scope, $stateParams, Palestrantes) {
  $scope.palestrantes = Palestrantes.all();
})