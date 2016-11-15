/**
 * 
 */
angular.
	module('phoneDetail').
	component('phoneDetail',{
		templateUrl:'script/app/phone-detail/phone-detail.template.html',
		controller:['$http','$routeParams',
		            function PhoneDetailController($http, $routeParams){
						var self = this;
						self.setImage = function setImage(imageUrl) {
						      self.mainImageUrl = imageUrl;
						    };
				        $http.get('script/app/phones/' + $routeParams.phoneId + '.json').then(function(response) {
				          self.phone = response.data;
				          self.setImage(self.phone.images[0]);
				        });
					}		
		]
	
	})