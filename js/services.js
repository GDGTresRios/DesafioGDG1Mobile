angular.module('starter.services', [])

.factory('Empresas', function() {
  var empresas = [{
    id: 0,
    name: 'API Systems',
    lastText: 'Desenvolvimento de software',
    face: '/GDGCentroSulTabs/www/img/ionic.png',
    descricao: 'Detalhes...'
  }, {
    id: 1,
    name: 'Zaal',
    lastText: 'Desenvolvimento de Software',
    face: '/GDGCentroSulTabs/www/img/ionic.png',
    descricao: 'Detalhes...'
  },{
    id: 2,
    name: 'Sig2000',
    lastText: 'Desenvolvimento de Software',
    face: '/GDGCentroSulTabs/www/img/ionic.png',
    descricao: 'Detalhes...'
  }, {
    id: 3,
    name: 'GDG Três Rios',
    lastText: 'Google Developers Group',
    face: '/GDGCentroSulTabs/www/img/ionic.png',
    descricao: 'Detalhes...'
  }];

  return {
    all: function() {
      return empresas;
    },
    get: function(chatId) {
      for (var i = 0; i < empresas.length; i++) {
        if (empresas[i].id === parseInt(chatId)) {
          return empresas[i];
        }
      }
      return null;
    }
  };
})


.factory('Palestrantes', function() {
  var palestrantes = [{
    id: 0,
    name: 'GDG Três Rios',
    lastText: 'Desenvolvimento de software',
    face: '/GDGCentroSulTabs/www/img/ionic.png',
    descricao: 'Detalhes...'
  }, 
  {
    id: 1,
    name: 'CVT Três Rios',
    lastText: 'Centro Vocacional Tecnologico de Três Rios',
    face: '/GDGCentroSulTabs/www/img/ionic.png',
    descricao: 'Detalhes...'
  }];

  return {
    all: function() {
      return palestrantes;
    },
    get: function(chatId) {
      for (var i = 0; i < palestrantes.length; i++) {
        if (palestrantes[i].id === parseInt(chatId)) {
          return palestrantes[i];
        }
      }
      return null;
    }
  };
});
