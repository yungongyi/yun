var TableAdvanced = function() {

	var initTable1 = function() {

		/* Formating function for row details */
		function fnFormatDetails(oTable, nTr) {
			var aData = oTable.fnGetData(nTr);
			var sOut = '<table>';
			sOut += '<tr><td>Platform(s):</td><td>' + aData[2] + '</td></tr>';
			sOut += '<tr><td>Engine version:</td><td>' + aData[3] + '</td></tr>';
			sOut += '<tr><td>CSS grade:</td><td>' + aData[4] + '</td></tr>';
			sOut += '<tr><td>Others:</td><td>Could provide a link here</td></tr>';
			sOut += '</table>';

			return sOut;
		}

		/*
		 * Insert a 'details' column to the table
		 */
		var nCloneTh = document.createElement('th');
		var nCloneTd = document.createElement('td');
		nCloneTd.innerHTML = '<span class="row-details row-details-close"></span>';

		$('#sample_1 thead tr').each(function() {
			this.insertBefore(nCloneTh, this.childNodes[0]);
		});

		$('#sample_1 tbody tr').each(function() {
			this.insertBefore(nCloneTd.cloneNode(true), this.childNodes[0]);
		});

		/*
		 * Initialse DataTables, with no sorting on the 'details' column
		 */
		var oTable = $('#sample_1').dataTable({
			"aoColumnDefs": [{
				"bSortable": false,
				"aTargets": [0]
			}],
			"aaSorting": [
				[1, 'asc']
			],
			"aLengthMenu": [
				[5, 15, 20, -1],
				[5, 15, 20, "全部"] // change per page values here
			],
			// set the initial value
			"iDisplayLength": 10,
		});

		jQuery('#sample_1_wrapper .dataTables_filter input').addClass("m-wrap small"); // modify table search input
		jQuery('#sample_1_wrapper .dataTables_length select').addClass("m-wrap small"); // modify table per page dropdown

		/* Add event listener for opening and closing details
		 * Note that the indicator for showing which row is open is not controlled by DataTables,
		 * rather it is done here
		 */
		$('#sample_1').on('click', ' tbody td .row-details', function() {
			var nTr = $(this).parents('tr')[0];
			if(oTable.fnIsOpen(nTr)) {
				/* This row is already open - close it */
				$(this).addClass("row-details-close").removeClass("row-details-open");
				oTable.fnClose(nTr);
			} else {
				/* Open this row */
				$(this).addClass("row-details-open").removeClass("row-details-close");
				oTable.fnOpen(nTr, fnFormatDetails(oTable, nTr), 'details');
			}
		});
	}
	var initTable2 = function() {

		/* Formating function for row details */
		function fnFormatDetails(oTable, nTr) {
			var aData = oTable.fnGetData(nTr);
			var sOut = '<table>';
			sOut += '<tr><td>Platform(s):</td><td>' + aData[2] + '</td></tr>';
			sOut += '<tr><td>Engine version:</td><td>' + aData[3] + '</td></tr>';
			sOut += '<tr><td>CSS grade:</td><td>' + aData[4] + '</td></tr>';
			sOut += '<tr><td>Others:</td><td>Could provide a link here</td></tr>';
			sOut += '</table>';

			return sOut;
		}

		/*
		 * Insert a 'details' column to the table
		 */
		var nCloneTh = document.createElement('th');
		var nCloneTd = document.createElement('td');
		nCloneTd.innerHTML = '<span class="row-details row-details-close"></span>';

		$('#sample_2 thead tr').each(function() {
			this.insertBefore(nCloneTh, this.childNodes[0]);
		});

		$('#sample_2 tbody tr').each(function() {
			this.insertBefore(nCloneTd.cloneNode(true), this.childNodes[0]);
		});

		/*
		 * Initialse DataTables, with no sorting on the 'details' column
		 */
		var oTable = $('#sample_2').dataTable({
			"aoColumnDefs": [{
				"bSortable": false,
				"aTargets": [0]
			}],
			"aaSorting": [
				[1, 'asc']
			],
			"aLengthMenu": [
				[5, 15, 20, -1],
				[5, 15, 20, "全部"] // change per page values here
			],
			// set the initial value
			"iDisplayLength": 10,
		});

		jQuery('#sample_2_wrapper .dataTables_filter input').addClass("m-wrap small"); // modify table search input
		jQuery('#sample_2_wrapper .dataTables_length select').addClass("m-wrap small"); // modify table per page dropdown

		/* Add event listener for opening and closing details
		 * Note that the indicator for showing which row is open is not controlled by DataTables,
		 * rather it is done here
		 */
		$('#sample_2').on('click', ' tbody td .row-details', function() {
			var nTr = $(this).parents('tr')[0];
			if(oTable.fnIsOpen(nTr)) {
				/* This row is already open - close it */
				$(this).addClass("row-details-close").removeClass("row-details-open");
				oTable.fnClose(nTr);
			} else {
				/* Open this row */
				$(this).addClass("row-details-open").removeClass("row-details-close");
				oTable.fnOpen(nTr, fnFormatDetails(oTable, nTr), 'details');
			}
		});
	}
	var initTable3 = function() {

		/* Formating function for row details */
		function fnFormatDetails(oTable, nTr) {
			var aData = oTable.fnGetData(nTr);
			var sOut = '<table>';
			sOut += '<tr><td>Platform(s):</td><td>' + aData[2] + '</td></tr>';
			sOut += '<tr><td>Engine version:</td><td>' + aData[3] + '</td></tr>';
			sOut += '<tr><td>CSS grade:</td><td>' + aData[4] + '</td></tr>';
			sOut += '<tr><td>Others:</td><td>Could provide a link here</td></tr>';
			sOut += '</table>';

			return sOut;
		}

		/*
		 * Insert a 'details' column to the table
		 */
		var nCloneTh = document.createElement('th');
		var nCloneTd = document.createElement('td');
		nCloneTd.innerHTML = '<span class="row-details row-details-close"></span>';

		$('#sample_3 thead tr').each(function() {
			this.insertBefore(nCloneTh, this.childNodes[0]);
		});

		$('#sample_3 tbody tr').each(function() {
			this.insertBefore(nCloneTd.cloneNode(true), this.childNodes[0]);
		});

		/*
		 * Initialse DataTables, with no sorting on the 'details' column
		 */
		var oTable = $('#sample_3').dataTable({
			"aoColumnDefs": [{
				"bSortable": false,
				"aTargets": [0]
			}],
			"aaSorting": [
				[1, 'asc']
			],
			"aLengthMenu": [
				[5, 15, 20, -1],
				[5, 15, 20, "全部"] // change per page values here
			],
			// set the initial value
			"iDisplayLength": 10,
		});

		jQuery('#sample_3_wrapper .dataTables_filter input').addClass("m-wrap small"); // modify table search input
		jQuery('#sample_3_wrapper .dataTables_length select').addClass("m-wrap small"); // modify table per page dropdown

		/* Add event listener for opening and closing details
		 * Note that the indicator for showing which row is open is not controlled by DataTables,
		 * rather it is done here
		 */
		$('#sample_3').on('click', ' tbody td .row-details', function() {
			var nTr = $(this).parents('tr')[0];
			if(oTable.fnIsOpen(nTr)) {
				/* This row is already open - close it */
				$(this).addClass("row-details-close").removeClass("row-details-open");
				oTable.fnClose(nTr);
			} else {
				/* Open this row */
				$(this).addClass("row-details-open").removeClass("row-details-close");
				oTable.fnOpen(nTr, fnFormatDetails(oTable, nTr), 'details');
			}
		});
	}
	var initTable4 = function() {

		/* Formating function for row details */
		function fnFormatDetails(oTable, nTr) {
			var aData = oTable.fnGetData(nTr);
			var sOut = '<table>';
			sOut += '<tr><td>Platform(s):</td><td>' + aData[2] + '</td></tr>';
			sOut += '<tr><td>Engine version:</td><td>' + aData[3] + '</td></tr>';
			sOut += '<tr><td>CSS grade:</td><td>' + aData[4] + '</td></tr>';
			sOut += '<tr><td>Others:</td><td>Could provide a link here</td></tr>';
			sOut += '</table>';

			return sOut;
		}

		/*
		 * Insert a 'details' column to the table
		 */
		var nCloneTh = document.createElement('th');
		var nCloneTd = document.createElement('td');
		nCloneTd.innerHTML = '<span class="row-details row-details-close"></span>';

		$('#sample_4 thead tr').each(function() {
			this.insertBefore(nCloneTh, this.childNodes[0]);
		});

		$('#sample_4 tbody tr').each(function() {
			this.insertBefore(nCloneTd.cloneNode(true), this.childNodes[0]);
		});

		/*
		 * Initialse DataTables, with no sorting on the 'details' column
		 */
		var oTable = $('#sample_4').dataTable({
			"aoColumnDefs": [{
				"bSortable": false,
				"aTargets": [0]
			}],
			"aaSorting": [
				[1, 'asc']
			],
			"aLengthMenu": [
				[5, 15, 20, -1],
				[5, 15, 20, "全部"] // change per page values here
			],
			// set the initial value
			"iDisplayLength": 10,
		});

		jQuery('#sample_4_wrapper .dataTables_filter input').addClass("m-wrap small"); // modify table search input
		jQuery('#sample_4_wrapper .dataTables_length select').addClass("m-wrap small"); // modify table per page dropdown

		/* Add event listener for opening and closing details
		 * Note that the indicator for showing which row is open is not controlled by DataTables,
		 * rather it is done here
		 */
		$('#sample_4').on('click', ' tbody td .row-details', function() {
			var nTr = $(this).parents('tr')[0];
			if(oTable.fnIsOpen(nTr)) {
				/* This row is already open - close it */
				$(this).addClass("row-details-close").removeClass("row-details-open");
				oTable.fnClose(nTr);
			} else {
				/* Open this row */
				$(this).addClass("row-details-open").removeClass("row-details-close");
				oTable.fnOpen(nTr, fnFormatDetails(oTable, nTr), 'details');
			}
		});
	}

	return {

		//main function to initiate the module
		init: function() {

			if(!jQuery().dataTable) {
				return;
			}
			initTable1();
			initTable2();
			initTable3();
			initTable4();
		}

	};

}();