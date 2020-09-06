<#include "header.ftl">
<!-- /section:basics/navbar.layout -->
<div class="main-container" id="main-container">
    <script type="text/javascript">
        try {
            ace.settings.check('main-container', 'fixed')
        } catch (e) {
        }

        function setIframeHeight(iframe) {
            if (iframe) {
                var iframeWin = iframe.contentWindow || iframe.contentDocument.parentWindow;
                if (iframeWin.document.body) {
                    iframe.height = iframeWin.document.documentElement.scrollHeight || iframeWin.document.body.scrollHeight;
                }
            }
        };

        window.onload = function () {
            setIframeHeight(document.getElementById('external-frame'));
        };
    </script>

    <#include "menu.ftl">

    <!-- /section:basics/sidebar -->
    <div class="main-content common-body">
        <!-- #section:basics/content.breadcrumbs -->
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try {
                    ace.settings.check('breadcrumbs', 'fixed')
                } catch (e) {
                }
            </script>

            <ul class="breadcrumb" style="margin-top: 10px;">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="${path }/admin">主页</a>
                </li>
            </ul> <!-- /.breadcrumb -->
        </div>

        <div class="page-content" style="padding: 0px;">
            <iframe id="contentFrame" width="100%" framespacing="0" border="false" frameborder="0"
                    scrolling="no" onload="setIframeHeight(this)"></iframe>
        </div>


