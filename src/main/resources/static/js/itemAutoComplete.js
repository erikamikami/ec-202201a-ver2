$(function() {
var words = [
      "Gorgeous4サンド",
      "エスプレッソフラペチーノ",
      "Specialキャラメルドーナッツ",
      "チョコクッキー",
      "カフェモカ",
      "カフェラテ",
      "カプチーノ",
      "キャラメルマキアート",
      "キャラメルフラペチーノ",
      "バニラ クリーム フラペチーノ",
      "ダークモカフラペチーノ",
      "抹茶クリームフラペチーノ",
      "ドリップコーヒー",
      "アイスコーヒー",
      "アメリカン",
      "エスプレッソ",
      "ナッティホワイトモカ",
      "ジンジャーブレッドラテ"
    ];
    $( "#code" ).autocomplete({
      source: words,
    });
});
