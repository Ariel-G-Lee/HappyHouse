<template> 
<!--로그아웃 모달-->
  <div id="modalLogout" class="modal" tabindex="-1">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title">로그아웃</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <p>로그아웃 하시겠습니까?</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-green">로그아웃</button>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name: 'Logout',
}
</script>
<style>
  
</style>