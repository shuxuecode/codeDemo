class Global {
    static Map<String, Object> hashMap = [
            "a": [
                    "A": 1,
                    "B": 2,
                    "C": 3
            ],
            "b": [
                    "A": 5,
                    "B": 6,
                    "C": 7
            ]
    ]
}

def run(Object map) {

    println(map instanceof Map)
    println(map instanceof List)

    Map res = []

    for (entry in map) {

        def value = Global.hashMap.get(entry.key)

        res[entry.key] = value[entry.value]
    }

    return res
}


def calculate(int a, int b, String c) {
    return c + (a + b)
}