function readURL1(input) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();

		reader.onload = function(e) {
			$('#blahAvatar').attr('src', e.target.result);
		}
		$('#blahAvatar').show();
		$("#avatarMessage").hide();
		reader.readAsDataURL(input.files[0]);
	}
}

$("#imgInpAvatar").change(function() {
	readURL1(this);
});

function readURL2(input) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();

		reader.onload = function(e) {
			$('#blahResume').attr('src', e.target.result);
		}
		$('#blahResume').show();
		$("#resumeMessage").hide();
		reader.readAsDataURL(input.files[0]);
	}
}

$("#imgInpResume").change(function() {
	readURL2(this);
});