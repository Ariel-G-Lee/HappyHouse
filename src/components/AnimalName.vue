<template>
	<div id="anlmai-name">
		<cloud :data="words" :fontSizeMapper="fontSizeMapper" />
	</div>
</template>

<script>
import Cloud from 'vue-d3-cloud'
//animalname get
export default {
	name: 'AnimalName',
	data() {
		return {
			words: [
				{ text: 'Vue', value: 1000 },
				{ text: 'js', value: 200 },
				{ text: 'is', value: 800 },
				{ text: 'very cool', value: 1000000 },
				{ text: 'lunch', value: 100 },
			],
			fontSizeMapper: word => Math.log2(word.value) * 5,
		}
	},
	components: {
		Cloud,
	},
}
</script>