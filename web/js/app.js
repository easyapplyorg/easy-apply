$(function () {
    alert = $("#successMessage");

    const url = window.location.origin + window.location.pathname.replace("view-detail", "view-vacancies");

    content = `<div id="successMessage" class="alert alert-success alert-dismissible" role="alert">You have successfully applied for this opening. Click <a
            href="${url}">here</a> to browse more openings!
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>`;

    const link = $("#submitApplication");
    // link.click(submitApplication, event)
});

function submitApplication(event) {
    const url = this.href;
    $.ajax({
        url: url,
        type: "GET"
    })
        .done(function (response) {
            if (data.redirect) {
                // data.redirect contains the string URL to redirect to
                window.location.href = data.redirect;
            } else {
                alert.html("");
                alert.append(content);
                console.log("Response: " + response) // debug
            }
        })
        .fail(function (xhr, status, errorThrown) {
            console.log(`Error: ${errorThrown}\nStatus: ${status}`);
            console.dir(xhr);
        });
    return false // event.preventDefault()
}
