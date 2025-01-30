## Использование

На вход подаётся строка - путь до файла конфигурации в формате json.
Пример файла конфигурации можно найти по пути src/main/resources/config.json
Файл обязан соответствовать установленной json схеме.

## Конфигурация системы

### CPU

Architecture:                       x86_64

CPU op-mode(s):                     32-bit, 64-bit

Byte Order:                         Little Endian

Address sizes:                      39 bits physical, 48 bits virtual

CPU(s):                             12

On-line CPU(s) list:                0-11

Thread(s) per core:                 2

Core(s) per socket:                 6

Socket(s):                          1

Vendor ID:                          GenuineIntel

CPU family:                         6

Model:                              167

Model name:                         11th Gen Intel(R) Core(TM) i5-11400 @ 2.60GHz

Stepping:                           1

CPU MHz:                            2591.998

BogoMIPS:                           5183.99

Hypervisor vendor:                  Microsoft

Virtualization type:                full

L1d cache:                          288 KiB

L1i cache:                          192 KiB

L2 cache:                           3 MiB

L3 cache:                           12 MiB

## Результаты теста производительности

#### Последовательный режим
- время выполнения: 260 ms

#### Параллельный режим
- На 5 потоках: среднее время выполнения 104 ms

- На 9 потоках: среднее время выполнения 62 ms

- На 10 потоках: среднее время выполнения: 60 ms

При дальнейшем увеличении числа потоков прирост производительности не наблюдается.

