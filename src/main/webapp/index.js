function arrayObjectIndexOf(myArray, searchTerm, property) {
    for(var i = 0, len = myArray.length; i < len; i++) {
        if (myArray[i][property] === searchTerm) return i;
    }
    return -1;
}

var serviceModule = angular.module('amigoModule', []);

serviceModule.controller("AmigoController", function($scope, $http) {
	
		var response = $http.get('rest/ListarAmigo');
		
		response.success(function(data, status, headers, config) {
			$scope.amigos=data;
		});
		response.error(function(data, status, headers, config) {
			alert( "Exception details: " + JSON.stringify({data: data}));
		});

		$scope.salvar=function()
		{
				
			var amigoObj = {
					"id" : $scope.id,
					"nome" : $scope.nome,
					"email" : $scope.email
			};		
			
			if($scope.id == null)
				var response = $http.post('rest/GravarAmigo', amigoObj);
			else
				var response = $http.post('rest/AlterarAmigo', amigoObj);
			
			response.success(function(data, status, headers, config) {
				if($scope.id == null){				
					$scope.amigos.push(amigoObj);	
				}
				else{
					$scope.amigos.splice([arrayObjectIndexOf($scope.amigos,$scope.id,"id")],1,amigoObj);				
				}
				alert("Gravação efetuada com sucesso!");
				$scope.limpar();
			});
			response.error(function(data, status, headers, config) {
				alert( "Exception details: " + JSON.stringify({data: data}));
			});
		
			
		}
	
		$scope.selecionar=function(id)
		{

			var amigo = $scope.amigos[arrayObjectIndexOf($scope.amigos,id,"id")];
			
			$scope.id = amigo.id;
			$scope.nome = amigo.nome;
			$scope.email = amigo.email;
			
		}
		
		$scope.excluir=function(id)
		{

			if(confirm("Deseja realmente excluir este registro?"))
			{
			
				var response = $http.post('rest/ExcluirAmigo/' + id);
				
				response.success(function(data, status, headers, config) {
					alert("Exclusão efetuada com sucesso!");
					$scope.amigos.splice( arrayObjectIndexOf($scope.amigos,id,"id"), 1 );
					
				});
				response.error(function(data, status, headers, config) {
					alert( "Exception details: " + JSON.stringify({data: data}));
				});
			
			}
			
			$scope.limpar();
			
		}
		
		$scope.teste=function()
		{

			var response = $http.post('rest/SortearAmigo/',$scope.amigos);

			response.success(function(data, status, headers, config) {
				$scope.amigos=data;
			});
			response.error(function(data, status, headers, config) {
				alert( "Exception details: " + JSON.stringify({data: data}));
			});
		
		}
		
		
		$scope.limpar=function()
		{
			
			$scope.id = null;
			$scope.nome = null;
			$scope.email = null;
			
		}
		
});