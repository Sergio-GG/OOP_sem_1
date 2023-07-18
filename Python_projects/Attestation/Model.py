import os.path
import time
import json
import pandas as pd



def create_note(name):
    data = open(f"{name}.json", 'a')
    data.close()
    string = f"{name}.json"
    print("Создано")
    # создаем заметку
    return string


def edit_note(name):
    # with open(f"{name}.json", "w+") as a:
    value = input("Введите заголовок, значение которого вы хотите изменить (Id, Title, Body): ")
    time_edit = os.path.getmtime(f'{name}.json')
    match value:
        case "Id":
            val = input("Введите номер идентификатора заметки: ")
            with open(f"{name}.json", "r") as a:
                lst = list(a)
                a.close()

            with open(f"{name}.json", "w") as a:
                index = 0
                for i in lst:
                    if index == 1:
                        a.write(f'\t"Id" : {val},\n')
                        index += 1
                        continue
                    if index == 4:
                        a.write(f'\t"Time" : "{time.ctime(time_edit)}"\n')
                        index += 1
                        continue
                    a.write(i)
                    index += 1
                a.close()
        case "Title":
            val = input("Введите значение заголовка заметки: ")
            with open(f"{name}.json", "r") as a:
                lst = list(a)
                a.close()
            with open(f"{name}.json", "w") as a:
                index = 0
                for i in lst:
                    if index == 2:
                        a.write(f'\t"Title" : "{val}",\n')
                        index += 1
                        continue
                    if index == 4:
                        a.write(f'\t"Time" : "{time.ctime(time_edit)}"\n')
                        index += 1
                        continue
                    a.write(i)
                    index += 1
                a.close()

        case "Body":
            val = input("Введите значение заголовка заметки: ")
            with open(f"{name}.json", "r") as a:
                lst = list(a)
                a.close()
            with open(f"{name}.json", "w") as a:
                index = 0
                for i in lst:
                    if index == 3:
                        a.write(f'\t"Body" : "{val}",\n')
                        index += 1
                        continue
                    if index == 4:
                        a.write(f'\t"Time" : "{time.ctime(time_edit)}"\n')
                        index += 1
                        continue
                    a.write(i)
                    index += 1
                a.close()

    print("Отредактировано")


def read_note(name):
    with open(f'{name}.json') as a:
        for i in a:
            print(i)
        a.close()
    print("Прочитано")
    # Read note


def delete_note(name):
    os.remove(f'{name}.json')
    with open("1.txt") as a:
        lst = list(a)
        a.close()
    with open("1.txt", "w") as a:
        for i in lst:
            if i.strip() != name:
                a.write(i)
        a.close()
    print("Удалено")
    # Delete note


def fields_note(data):
    print("Введите поля:")
    Id = input("Id: ")
    title = input("Title: ")
    body = input("Body: ")
    time_edit = os.path.getctime(data)

    with open(data, "w") as d:
        d.write('{\n')
        d.write(f'\t"Id" : {Id},\n')
        d.write(f'\t"Title" : "{title}",\n')
        d.write(f'\t"Body" : "{body}",\n')
        d.write(f'\t"Time" : "{time.ctime(time_edit)}"\n')
        d.write('}\n')
        d.close()

    # Create fields of note
    print("Заметка создана")


def name_check(name):
    counter = 0
    with open("1.txt", "a") as a:
        a.close()
    with open("1.txt", "r") as a:

        for i in a:
            if i.strip() == name:
                counter += 1
        a.close()
    if counter > 0:
        return False
    else:
        return True


def add_to_txt_file(name):
    a = open("1.txt", "a")
    a.write(f'{name}\n')
    a.close()
    print("Добавлено в файл")


def list_of_notes():
    list_of_n = []
    try:
        with open("1.txt") as a:
            lst = list(a)
            a.close()
        for i in lst:
            list_of_n.append(f'{i.strip()}.json')

        return list_of_n
    except:
        return list_of_n




def notes_data_dict(dictionar):
    dict_new = {}
    for k in dictionar:
        with open(k) as data:
            lines_json = data.read()
            lines = json.loads(lines_json)
            dict_new[k] = lines
            data.close()
    #print(dict_new)
    return dict_new


def data_of_notes():
    dict_of_notes = {}
    with open("1.txt") as a:
        lst = list(a)
        a.close()
    index = 1
    for i in lst:
        dict_of_notes[f"{i.strip()}.json"] = index
        index += 1
    #print(dict_of_notes)
    return dict_of_notes


def get_data(dictionary, ans, ans2):
    dict1 = {}

    for i in dictionary:
        if i == f"{ans}.json":
            dict1 = dictionary[i]

    if ans2 != "":
        for j in dict1:
            if j == ans2:
                res = dict1[j]
    return res


def selection(ask):
    dict_of_notes = {}
    with open("1.txt") as a:
        lst = list(a)
        a.close()
    index = 1
    for i in lst:
        dict_of_notes[f"{i.strip()}.json"] = index
        index += 1
    # print(dict_of_notes)

    dict_new = {}
    list_a =[]
    for k in dict_of_notes:
        with open(k) as data:
            lines_json = data.read()
            lines = json.loads(lines_json)
            k = lines
            list_a.append(k)
            data.close()
    #print(list_a)
    try:
        df = pd.DataFrame(list_a)
        print(df[[f"{ask}"]])
    except:
        print("Введите корректые данные")

def is_empty_txt():
    try:
        with open("1.txt") as a:
            lst = list(a)
            a.close()
            if lst == []:
                return None
            else:
                return lst
    except:
        return None
