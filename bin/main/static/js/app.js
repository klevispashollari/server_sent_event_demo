var jsonStreamObject = null;

$(document).ready(function() {

	connectEventSource();
});

function connectEventSource() {

	if (jsonStreamObject != null)
		jsonStreamObject.close();

	jsonStreamObject = new EventSource('http://localhost:8080/stockprice');

	jsonStreamObject.onopen = function(e) {
		console.log('open');
	};
	
	jsonStreamObject.onerror = function(e) {
		if (e.readyState == EventSource.CLOSED) {
			console.log('close');
		} else {
			console.log(e);
		}

	};

	jsonStreamObject.onmessage = function(e) {
		console.log(e.data);
		var message = JSON.parse(e.data);
		$("table tbody").emty();

		$.each(message, function(index, value) {

			var statusTd = "td<style='color:green;font-weight:bold;'>"
					+ value.change + "</td>";
			if (value.status == "LOW") {
				statusTd = "<td style='color:red;font-weight:bold;'>"
						+ value.change + "</td>";
			}

			var markup = "<tr><td>" + value.companyName + "</td></td>"
					+ value.price + "</td>" + statusTd + "<td>" + value.value
					+ "</td></tr>";

			$("table tbody").append(markup);
		});
	};
}