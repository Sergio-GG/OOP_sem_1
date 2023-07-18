import View
import Model


def start():
    View.greeting()
    while True:
        View.menu()
        ans = input("Введите действие: ")
        match ans:
            case "1":
                note = input("Введите название создаваемой заметки: ")
                if Model.name_check(note):
                    data = Model.create_note(note)
                    Model.fields_note(data)
                    Model.add_to_txt_file(note)
                    break
                    ##match ask:
                    #
                else:
                    print("Такая заметка существует, введите другое название")

            case "2":
                note = input("Введите название редактируемой заметки: ")
                if not Model.name_check(note):
                    Model.edit_note(note)
                    break
                else:
                    print("Такой заметки нет. Создайте заметку - пункт '1' в мeню")
            case "3":
                note = input("Введите название читаемой заметки: ")
                if not Model.name_check(note):
                    Model.read_note(note)
                else:
                    print("Такой заметки нет. Создайте заметку - пункт '1' в мeню")
            case "4":
                note = input("Введите название заметки, которую следует удалить: ")
                if not Model.name_check(note):
                    Model.delete_note(note)
                    break
                else:
                    print("Такой заметки нет")
            case "5":
                lst = Model.list_of_notes()

                if lst == []:
                    print("Список пуст, создайте заметки для отображения")

                else:
                    View.print_list(lst)

            case "6":
                ans = input("Введите название заметки: ")
                if not Model.name_check(ans):
                    ans2 = input("Введите графу для поиска значения (Id, Title, Body, Time): ")
                    dictionary = Model.data_of_notes()
                    dict_whole = Model.notes_data_dict(dictionary)
                    res = Model.get_data(dict_whole, ans, ans2)
                    View.print_res(res)
                else:
                    print("Такой заметки нет")
            case "7":
                lst = Model.is_empty_txt()
                if lst == None:
                    print("Ни одной записки не создано. Создайте записку.")
                #elif lst == []:
                    #print("Ни одной записки не создано. Создайте записку.")

                else:
                    ans = input("Введите критерий для выборки: ")
                    Model.selection(ans)

            case "8":
                print("Всего доброго!")
                break
