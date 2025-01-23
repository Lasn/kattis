p, c = [int(i) for i in input().split(" ")]

if p == 2 and c == 0:
    print("yes")
    quit()

yes_no = set()


def play(cards_left, players_turn):
    if cards_left == 0:
        if players_turn == p - 1:
            yes_no.add("yes")
            return
        else:
            yes_no.add("no")
            return

    if players_turn == p - 1:
        return

    max_play_cards = 0
    if cards_left >= p - 1:
        max_play_cards = p - 1
    else:
        max_play_cards = cards_left

    for i in range(1, max_play_cards + 1):
        nextplayer = (players_turn + 1 + i) % p
        play(cards_left - i, nextplayer)
    return


play(c, 0)

if len(yes_no) > 1:
    print("maybe")
elif len(yes_no) == 0:
    print("no")
else:
    print(*yes_no)
