<template> 
  <div>
    <h4>매물 목록</h4>
    <table class="table table-hover">
      <thead>
        <tr>
          <th>번호</th>
          <th>동명</th>
          <th>아파트명</th>
          <th>가격</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(house, index) in listGetters" @click="houseDetail(house.no)" v-bind:key="index">
          <td>{{ house.no }}</td>
          <td>{{ house.dongName }}</td>
          <td>{{ house.aptName }}</td>
          <td>{{ house.dealAmount }}</td>
        </tr>
      </tbody>
    </table>
    <pagination-house v-on:call-parent="movePage"></pagination-house>
  </div> 
</template>
<script>  
import http from "@/common/axios.js";
import PaginationHouse from "./PaginationHouse"

export default {
  name: 'HouseList',
  components: { PaginationHouse },
  computed: {
    listGetters(){
      return this.$store.getters.getHouseList;
    },
  },
  methods: {
    houseList(){
      this.$store.dispatch('houseList');
    },

    movePage(pageIndex){
      console.log("houseListVue : movePage : pageIndex : " + pageIndex );

      // store commit 으로 변경
      // this.offset = (pageIndex - 1) * this.listRowCount;
      // this.currentPageIndex = pageIndex;
      this.$store.commit( 'SET_HOUSE_MOVE_PAGE', pageIndex );
      this.houseList();
    },

    houseDetail(no){
      console.log(no);
      
      // store 변경
      // this.boardId = boardId;
      // this.$store.commit('mutateSetBoardBoardId', boardId);

      http.get(
      '/houses/'+no,
      )
      .then(({ data }) => { 
        console.log("HouseDetail: data : ");
        console.log(data);

        if( data.result == 'login' ){
          this.$router.push("/login")
        }else{
          this.$store.commit(
            'SET_HOUSE_DETAIL',
            { no:data.no, dongName:data.dongName, aptName: data.aptName,dealAmount:data.dealAmount,
              area: data.area, buildYear:data.buildYear, dealMonth:data.dealMonth,dealDay:data.dealDay,
              lat:data.lat,lng:data.lng, jibun:data.jibun, floor:data.floor
            }
          );
          // this.$router.push("/housedetail");
          //house detail 컴포넌트 리프레쉬 !!!!
          console.log(this.$store.state.house.list)
          console.log(this.$store.house.aptName);
        }
      })
      .catch((error) => {
        console.log("HouseListVue: error ");
        console.log(error);
      });
    }
    
  },
  created() {
    this.houseList();
  },
}
</script>
<style>
  
</style>