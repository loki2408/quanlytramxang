document.addEventListener('DOMContentLoaded', function() {
    const toggleSidebarButton = document.getElementById('toggleSidebar');
    const sidebar = document.getElementById('sidebar');
    const mainContent = document.getElementById('main');

    toggleSidebarButton.addEventListener('click', () => {
        if (sidebar) {
            sidebar.classList.toggle('active');
        }
        mainContent.classList.toggle('sidebar-collapsed');
    });
});
