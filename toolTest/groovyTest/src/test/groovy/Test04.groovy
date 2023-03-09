static void main(String[] args) {
    t()
}


def t() {
//    Map<String, Integer> map = ["a":1, "b":2, "c":3, "d":4]
    Map<String, Integer> map = new HashMap<>();
    map.put("a", 1)
    map.put("b", 2)
    map.put("c", 3)
    map.put("d", 4)

    println map

    List list = []

//    for (final def entry in map) {
//        println entry
//        list << entry.key
//    }
    map.each {entry ->
        println(entry)
        if (entry.value > 2) {
            list << entry.key
        }
    }


    Collections.shuffle(list)

    println(list)

//    def keySet = map.keySet()
//    for(key in keySet){
//        println(key)
//    }


}