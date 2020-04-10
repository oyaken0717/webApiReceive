package com.example.controller;

//リストを実装したクラス。
import java.util.ArrayList;
//リスト。配列と違って格納できるデータは参照型のみ。
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//各アノテーションの読み込み
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.CreatureDTO;

//■	https://fresopiya.com/2019/09/16/webapijson/
//■ 「Jackson」が呼ばれる > オブジェクトとJSONの相互変換を行うライブラリ > 戻り値をJSON形式に変換
@RestController
public class humanJudgeController {

	@RequestMapping(value = "/judge", method = { RequestMethod.POST })
	public CreatureDTO judgeHuman(@RequestBody CreatureDTO creature) {
	// ■ @RequestBody:リクエストを取得し、指定された型に値を注入
	//	public List<CreatureDTO> judgeHuman(@RequestBody List<CreatureDTO> creature) {

		if ("human".equals(creature.getType())) {
			creature.setName("合ってる。");
		} else {
			creature.setName("違うのが入ってます。");
		}
		return creature;
	}
}