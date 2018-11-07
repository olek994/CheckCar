
function CheckCarSPA() {}

CheckCarSPA.currentStateURL = undefined;
CheckCarSPA.mainPartContentWrapperId = "main-content";


CheckCarSPA.addToHistory = function(url, patTitle){
    if(!CheckCarSPA.currentStateURL || CheckCarSPA.currentStateURL !== url){
        window.history.pushState({URL: url}, patTitle,url);
    }
    CheckCarSPA.currentStateURL = url;
};

CheckCarSPA.reloadPage = function (uriToLoad, addToHistory, onReloadCallback, page) {
  let pageTitle = uriToLoad;
  if(uriToLoad === "" || uriToLoad === undefined){
      uriToLoad = "/"
  }else if (!uriToLoad.startsWith("/")) { // jeżeli URL nie zaczyna się od naku '/', należy go dodać
      uriToLoad = "/" + uriToLoad;
  }

  if(addToHistory === undefined || addToHistory){
        CheckCarSPA.addToHistory(uriToLoad,pageTitle);
  }

  page = page === undefined ? true : page;

  if(page){
      uriToLoad += (uriToLoad.includes("?") ? "&" : "?") + "part=true";
  }

    $.ajax({
        url: uriToLoad,
        type: "GET",
        async: true,
        success: function (pageContent) {
            if(onReloadCallback) {
                onReloadCallback();
            }
            let contentWrapperElement = $('body');
            if(page) {
                contentWrapperElement = $("#" + CheckCarSPA.mainPartContentWrapperId);
                contentWrapperElement.fadeOut(350, function () {
                    contentWrapperElement.html(pageContent);
                    contentWrapperElement.fadeIn(350, function () {});
                });
            } else {
                document.open();
                document.write(pageContent);
                document.close();
            }
        },
        error: function () {

        }
    });


};

CheckCarSPA.refreshPage = function (onRefreshCallback) {
    CheckCarSPA.reloadPage(CheckCarSPA.currentStateURL, false, onRefreshCallback);
};

CheckCarSPA.refreshFullPage = function (onRefreshCallback) {
    CheckCarSPA.reloadPage(CheckCarSPA.currentStateURL, false, onRefreshCallback, false);
};