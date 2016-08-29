angular.module('phoneList').component('phoneList', {
	templateUrl : 'script/app/phone-list/phone-list.template.html',
	controller : [ '$http', function PhoneListController($http) {
		var self = this;
		self.orderProp = 'age';

		$http.get('script/app/phones.json').then(function(response) {
			self.phones = response.data;
		});
	} ]
});